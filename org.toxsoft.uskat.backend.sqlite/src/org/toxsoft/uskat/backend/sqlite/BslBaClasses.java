package org.toxsoft.uskat.backend.sqlite;

import java.util.*;

import org.toxsoft.core.tslib.bricks.events.msg.*;
import org.toxsoft.core.tslib.bricks.strid.coll.*;
import org.toxsoft.core.tslib.bricks.strid.coll.impl.*;
import org.toxsoft.core.tslib.coll.helpers.*;
import org.toxsoft.core.tslib.coll.primtypes.*;
import org.toxsoft.core.tslib.coll.primtypes.impl.*;
import org.toxsoft.core.tslib.gw.*;
import org.toxsoft.core.tslib.utils.errors.*;
import org.toxsoft.uskat.backend.sqlite.db.*;
import org.toxsoft.uskat.core.api.sysdescr.dto.*;
import org.toxsoft.uskat.core.backend.*;
import org.toxsoft.uskat.core.backend.api.*;

/**
 * {@link IBaClasses} implementation.
 *
 * @author hazard157
 */
class BslBaClasses
    extends BslAbstractAddon
    implements IBaClasses {

  /**
   * Constructor.
   *
   * @param aOwner {@link BslBackend} - the owner backend
   * @param aDb {@link IDbDriver} - access to the Sqlite data file
   * @throws TsNullArgumentRtException any argument = <code>null</code>
   */
  BslBaClasses( BslBackend aOwner, IDbDriver aDb ) {
    super( aOwner, aDb, ISkBackendHardConstant.BAINF_CLASSES );
  }

  // ------------------------------------------------------------------------------------
  // IBaClasses
  //

  @Override
  public IStridablesList<IDtoClassInfo> readClassInfos() {
    return db().loadClassInfos();
  }

  @Override
  public void writeClassInfos( IStringList aRemoveClassIds, IStridablesList<IDtoClassInfo> aUpdateClassInfos ) {
    TsIllegalArgumentRtException.checkTrue( aUpdateClassInfos.hasKey( IGwHardConstants.GW_ROOT_CLASS_ID ) );
    IStridablesListEdit<IDtoClassInfo> classInfos = new StridablesList<>();
    // prepare for frontend message
    IStringListEdit removedClassIds = new StringLinkedBundleList();
    IStringListEdit createdClassIds = new StringLinkedBundleList();
    IStringListEdit editedClassIds = new StringLinkedBundleList();
    // remove classes
    if( aRemoveClassIds != null ) {
      for( String classId : aRemoveClassIds ) {
        if( classInfos.removeById( classId ) != null ) {
          removedClassIds.add( classId );
        }
      }
    }
    else {
      if( !classInfos.isEmpty() ) {
        removedClassIds.addAll( classInfos.ids() );
        classInfos.clear();
      }
    }
    // add/update classes
    for( IDtoClassInfo inf : aUpdateClassInfos ) {
      IDtoClassInfo oldInf = classInfos.findByKey( inf.id() );
      if( !Objects.equals( inf, oldInf ) ) {
        if( oldInf != null ) {
          if( !oldInf.equals( inf ) ) {
            editedClassIds.add( inf.id() );
          }
        }
        else {
          createdClassIds.add( inf.id() );
        }
        classInfos.put( inf );
      }
    }
    // save changes
    db().writeClassInfos( classInfos );
    // inform frontend
    int totalCount = removedClassIds.size() + editedClassIds.size() + createdClassIds.size();
    switch( totalCount ) {
      case 0: { // no changes, nothing to inform about
        // nop
        break;
      }
      case 1: { // single change causes single class event
        ECrudOp op;
        String classId;
        if( !createdClassIds.isEmpty() ) {
          op = ECrudOp.CREATE;
          classId = createdClassIds.first();
        }
        else {
          if( !editedClassIds.isEmpty() ) {
            op = ECrudOp.EDIT;
            classId = editedClassIds.first();
          }
          else {
            op = ECrudOp.REMOVE;
            classId = removedClassIds.first();
          }
        }
        GtMessage msg = IBaClassesMessages.makeMessage( op, classId );
        owner().frontend().onBackendMessage( msg );
        break;
      }
      default: { // batch changes will fir ECrudOp.LIST event
        GtMessage msg = IBaClassesMessages.makeMessage( ECrudOp.LIST, null );
        owner().frontend().onBackendMessage( msg );
        break;
      }
    }
  }

}
