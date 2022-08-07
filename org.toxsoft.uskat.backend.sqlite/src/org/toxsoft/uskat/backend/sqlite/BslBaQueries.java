package org.toxsoft.uskat.backend.sqlite;

import org.toxsoft.core.tslib.av.opset.*;
import org.toxsoft.core.tslib.bricks.time.*;
import org.toxsoft.core.tslib.coll.primtypes.*;
import org.toxsoft.core.tslib.utils.errors.*;
import org.toxsoft.uskat.backend.sqlite.db.*;
import org.toxsoft.uskat.core.api.hqserv.*;
import org.toxsoft.uskat.core.backend.*;
import org.toxsoft.uskat.core.backend.api.*;

/**
 * {@link IBaQueries} implementation.
 *
 * @author hazard157
 */
public class BslBaQueries
    extends BslAbstractAddon
    implements IBaQueries {

  /**
   * Constructor.
   *
   * @param aOwner {@link BslBackend} - the owner backend
   * @param aDb {@link IDbDriver} - access to the Sqlite data file
   * @throws TsNullArgumentRtException any argument = <code>null</code>
   */
  BslBaQueries( BslBackend aOwner, IDbDriver aDb ) {
    super( aOwner, aDb, ISkBackendHardConstant.BAINF_CLASSES );
  }

  // ------------------------------------------------------------------------------------
  // IBaQueries
  //

  @Override
  public String createQuery( IOptionSet aParams ) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void prepareQuery( String aQueryId, IStringMap<IDtoQueryParam> aParams ) {
    // TODO Auto-generated method stub

  }

  @Override
  public void execQuery( String aQueryId, IQueryInterval aTimeInterval ) {
    // TODO Auto-generated method stub

  }

  @Override
  public void cancel( String aQueryId ) {
    // TODO Auto-generated method stub

  }

  @Override
  public void close( String aQueryId ) {
    // TODO Auto-generated method stub

  }

}
