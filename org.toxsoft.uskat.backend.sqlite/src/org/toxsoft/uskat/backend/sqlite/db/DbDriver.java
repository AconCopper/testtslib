package org.toxsoft.uskat.backend.sqlite.db;

import java.io.*;

import org.toxsoft.core.tslib.bricks.strid.coll.*;
import org.toxsoft.core.tslib.bricks.strid.coll.impl.*;
import org.toxsoft.uskat.core.api.sysdescr.dto.*;
import org.toxsoft.uskat.core.impl.dto.*;

/**
 * {@link IDbDriver} implementation.
 *
 * @author hazard157
 */
public class DbDriver
    implements IDbDriver {

  /**
   * Constructor.
   */
  public DbDriver() {
    // nop
  }

  // ------------------------------------------------------------------------------------
  // ICloseable
  //

  @Override
  public void close() {
    // TODO Auto-generated method stub

  }

  // ------------------------------------------------------------------------------------
  // IDbDriver
  //

  @Override
  public void init( File aSqliteFile ) {
    // TODO Auto-generated method stub

  }

  @Override
  public IStridablesList<IDtoClassInfo> loadClassInfos() {

    IStridablesListEdit<IDtoClassInfo> ll = new StridablesList<>();

    String content = ""; // load from DB
    IDtoClassInfo dto = DtoClassInfo.KEEPER.str2ent( content );

    ll.add( dto );

    // TODO Auto-generated method stub
    return ll;
  }

  @Override
  public void writeClassInfos( IStridablesList<IDtoClassInfo> aClassInfos ) {
    for( IDtoClassInfo dto : aClassInfos ) {
      String id = dto.id();
      String content = DtoClassInfo.KEEPER.ent2str( dto );

    }

    // TODO Auto-generated method stub

  }

}
