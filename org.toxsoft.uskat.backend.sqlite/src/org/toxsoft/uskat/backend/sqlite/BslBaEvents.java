package org.toxsoft.uskat.backend.sqlite;

import org.toxsoft.core.tslib.bricks.time.*;
import org.toxsoft.core.tslib.gw.gwid.*;
import org.toxsoft.core.tslib.utils.errors.*;
import org.toxsoft.uskat.backend.sqlite.db.*;
import org.toxsoft.uskat.core.api.evserv.*;
import org.toxsoft.uskat.core.backend.*;
import org.toxsoft.uskat.core.backend.api.*;

/**
 * {@link IBaEvents} implementation.
 *
 * @author hazard157
 */
class BslBaEvents
    extends BslAbstractAddon
    implements IBaEvents {

  /**
   * Constructor.
   *
   * @param aOwner {@link BslBackend} - the owner backend
   * @param aDb {@link IDbDriver} - access to the Sqlite data file
   * @throws TsNullArgumentRtException any argument = <code>null</code>
   */
  BslBaEvents( BslBackend aOwner, IDbDriver aDb ) {
    super( aOwner, aDb, ISkBackendHardConstant.BAINF_EVENTS );
  }

  // ------------------------------------------------------------------------------------
  // IBaEvents
  //

  @Override
  public void fireEvents( ISkEventList aEvents ) {
    // TODO Auto-generated method stub

  }

  @Override
  public void subscribeToEvents( IGwidList aNeededGwids ) {
    // TODO Auto-generated method stub

  }

  @Override
  public ITimedList<SkEvent> queryEvents( IQueryInterval aInterval, IGwidList aNeededGwids ) {
    // TODO Auto-generated method stub
    return null;
  }

}
