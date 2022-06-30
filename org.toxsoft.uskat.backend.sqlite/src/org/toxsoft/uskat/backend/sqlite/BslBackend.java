package org.toxsoft.uskat.backend.sqlite;

import static org.toxsoft.uskat.backend.sqlite.IBackendSqliteConstants.*;
import static org.toxsoft.uskat.backend.sqlite.ISkResources.*;

import java.io.*;

import org.toxsoft.core.tslib.bricks.ctx.*;
import org.toxsoft.core.tslib.coll.*;
import org.toxsoft.core.tslib.coll.impl.*;
import org.toxsoft.core.tslib.coll.primtypes.*;
import org.toxsoft.core.tslib.coll.primtypes.impl.*;
import org.toxsoft.core.tslib.utils.errors.*;
import org.toxsoft.core.tslib.utils.files.*;
import org.toxsoft.uskat.backend.sqlite.db.*;
import org.toxsoft.uskat.core.*;
import org.toxsoft.uskat.core.backend.*;
import org.toxsoft.uskat.core.backend.api.*;
import org.toxsoft.uskat.core.impl.*;

/**
 * BSL (<b>B</b>ackend <b>S</b>q<b>L</b>ite) backend.
 *
 * @author hazard157
 */
public class BslBackend
    implements ISkBackend {

  /**
   * The backend provider singleton.
   */
  public static final ISkBackendProvider PROVIDER = BslBackend::new;

  IListEdit<ISkServiceCreator<? extends AbstractSkService>> backendServicesCreators = new ElemArrayList<>();
  private final IStringMapEdit<BslAbstractAddon>            allAddons               = new StringMap<>();

  private final ITsContextRo    argContext;
  private final ISkFrontendRear frontend;
  private final SkBackendInfo   backendInfo;
  private final IDbDriver       db = new DbDriver();

  private final BslBaClasses  baClasses;
  private final BslBaClobs    baClobs;
  private final BslBaCommands baCommands;
  private final BslBaEvents   baEvents;
  private final BslBaLinks    baLinks;
  private final BslBaObjects  baObjects;
  private final BslBaRtdata   baRtdata;

  /**
   * Constructor.
   *
   * @param aFrontend {@link ISkFrontendRear} - the backside of the frontend
   * @param aArgs {@link ITsContextRo} - backend argument options and references
   * @throws TsNullArgumentRtException any argument = <code>null</code>
   */
  public BslBackend( ISkFrontendRear aFrontend, ITsContextRo aArgs ) {
    TsNullArgumentRtException.checkNulls( aFrontend, aArgs );
    backendInfo = new SkBackendInfo( BACKEND_ID, System.currentTimeMillis() );
    frontend = aFrontend;
    argContext = aArgs;
    if( !argContext.params().hasValue( OPDEF_FILE_PATH ) ) {
      throw new TsIllegalArgumentRtException( FMT_ERR_NO_FILE_NAME_SPECIFIED, OPDEF_FILE_PATH.id() );
    }
    String fileName = OPDEF_FILE_PATH.getValue( argContext().params() ).asString();
    File f = new File( fileName );
    TsFileUtils.checkFileAppendable( f );
    db.init( f );
    backendInfo.params().setStr( OPDEF_FILE_PATH, f.getAbsolutePath() );
    // addons initialization
    baClasses = new BslBaClasses( this, db );
    allAddons.put( baClasses.id(), baClasses );
    baObjects = new BslBaObjects( this, db );
    allAddons.put( baObjects.id(), baObjects );
    baClobs = new BslBaClobs( this, db );
    allAddons.put( baClobs.id(), baClobs );
    baLinks = new BslBaLinks( this, db );
    allAddons.put( baLinks.id(), baLinks );
    baEvents = new BslBaEvents( this, db );
    allAddons.put( baEvents.id(), baEvents );
    baRtdata = new BslBaRtdata( this, db );
    allAddons.put( baRtdata.id(), baRtdata );
    baCommands = new BslBaCommands( this, db );
    allAddons.put( baCommands.id(), baCommands );
  }

  // ------------------------------------------------------------------------------------
  // implementation
  //

  /**
   * Returns the context passed as arguments in constructor.
   *
   * @return {@link ITsContextRo} - creation arguments
   */
  ITsContextRo argContext() {
    return argContext;
  }

  // ------------------------------------------------------------------------------------
  // ICloseable
  //

  @Override
  public void close() {
    for( int i = allAddons.size() - 1; i >= 0; i-- ) {
      allAddons.values().get( i ).close();
    }
    db.close();
  }

  // ------------------------------------------------------------------------------------
  // ISkBackend
  //

  @Override
  public boolean isActive() {
    return true;
  }

  @Override
  public ISkBackendInfo getBackendInfo() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ISkFrontendRear frontend() {
    return frontend;
  }

  @Override
  public ITsContextRo openArgs() {
    return argContext;
  }

  @Override
  public IBaClasses baClasses() {
    return baClasses;
  }

  @Override
  public IBaObjects baObjects() {
    return baObjects;
  }

  @Override
  public IBaLinks baLinks() {
    return baLinks;
  }

  @Override
  public IBaEvents baEvents() {
    return baEvents;
  }

  @Override
  public IBaClobs baClobs() {
    return baClobs;
  }

  @Override
  public IBaRtdata baRtdata() {
    return baRtdata;
  }

  @Override
  public IBaCommands baCommands() {
    return baCommands;
  }

  @Override
  public IList<ISkServiceCreator<? extends AbstractSkService>> listBackendServicesCreators() {
    return backendServicesCreators;
  }

  @Override
  public <T> T findBackendAddon( String aAddonId, Class<T> aExpectedType ) {
    TsNullArgumentRtException.checkNulls( aAddonId, aExpectedType );
    Object rawAddon = allAddons.findByKey( aAddonId );
    return aExpectedType.cast( rawAddon );
  }

}
