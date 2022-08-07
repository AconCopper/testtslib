package org.toxsoft.uskat.backend.sqlite;

import org.toxsoft.core.tslib.av.opset.*;
import org.toxsoft.core.tslib.bricks.time.*;
import org.toxsoft.core.tslib.gw.gwid.*;
import org.toxsoft.core.tslib.gw.skid.*;
import org.toxsoft.core.tslib.utils.errors.*;
import org.toxsoft.uskat.backend.sqlite.db.*;
import org.toxsoft.uskat.core.api.cmdserv.*;
import org.toxsoft.uskat.core.backend.*;
import org.toxsoft.uskat.core.backend.api.*;
import org.toxsoft.uskat.core.impl.*;

/**
 * {@link IBaCommands} implementation.
 *
 * @author hazard157
 */
class BslBaCommands
    extends BslAbstractAddon
    implements IBaCommands {

  /**
   * Constructor.
   *
   * @param aOwner {@link BslBackend} - the owner backend
   * @param aDb {@link IDbDriver} - access to the Sqlite data file
   * @throws TsNullArgumentRtException any argument = <code>null</code>
   */
  BslBaCommands( BslBackend aOwner, IDbDriver aDb ) {
    super( aOwner, aDb, ISkBackendHardConstant.BAINF_COMMANDS );
  }

  // ------------------------------------------------------------------------------------
  // IBaCommands
  //

  @Override
  public SkCommand sendCommand( Gwid aCmdGwid, Skid aAuthorSkid, IOptionSet aArgs ) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void setHandledCommandGwids( IGwidList aGwids ) {
    // TODO Auto-generated method stub

  }

  @Override
  public void changeCommandState( DtoCommandStateChangeInfo aStateChangeInfo ) {
    // TODO Auto-generated method stub

  }

  @Override
  public IGwidList listGloballyHandledCommandGwids() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void saveToHistory( IDtoCompletedCommand aCompletedCommand ) {
    // TODO Auto-generated method stub

  }

  @Override
  public ITimedList<IDtoCompletedCommand> queryObjCommands( IQueryInterval aInterval, Gwid aGwid ) {
    // TODO Auto-generated method stub
    return null;
  }

}
