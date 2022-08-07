package org.toxsoft.uskat.backend.sqlite;

import org.toxsoft.core.tslib.av.*;
import org.toxsoft.core.tslib.av.temporal.*;
import org.toxsoft.core.tslib.bricks.time.*;
import org.toxsoft.core.tslib.gw.gwid.*;
import org.toxsoft.core.tslib.utils.errors.*;
import org.toxsoft.uskat.backend.sqlite.db.*;
import org.toxsoft.uskat.core.backend.*;
import org.toxsoft.uskat.core.backend.api.*;

/**
 * {@link IBaRtdata} implementation.
 *
 * @author hazard157
 */
class BslBaRtdata
    extends BslAbstractAddon
    implements IBaRtdata {

  /**
   * Constructor.
   *
   * @param aOwner {@link BslBackend} - the owner backend
   * @param aDb {@link IDbDriver} - access to the Sqlite data file
   * @throws TsNullArgumentRtException any argument = <code>null</code>
   */
  BslBaRtdata( BslBackend aOwner, IDbDriver aDb ) {
    super( aOwner, aDb, ISkBackendHardConstant.BAINF_RTDATA );
  }

  // ------------------------------------------------------------------------------------
  // IBaRtdata
  //

  @Override
  public void configureCurrDataReader( IGwidList aRtdGwids ) {
    // TODO Auto-generated method stub

  }

  @Override
  public void configureCurrDataWriter( IGwidList aRtdGwids ) {
    // TODO Auto-generated method stub

  }

  @Override
  public void writeCurrData( Gwid aGwid, IAtomicValue aValue ) {
    // TODO Auto-generated method stub

  }

  @Override
  public void writeHistData( Gwid aGwid, ITimeInterval aInterval, ITimedList<ITemporalAtomicValue> aValues ) {
    // TODO Auto-generated method stub

  }

  @Override
  public ITimedList<ITemporalAtomicValue> queryObjRtdata( IQueryInterval aInterval, Gwid aGwid ) {
    // TODO Auto-generated method stub
    return null;
  }

}
