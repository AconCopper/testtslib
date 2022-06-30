package org.toxsoft.uskat.backend.sqlite;

import org.toxsoft.core.tslib.gw.gwid.*;
import org.toxsoft.core.tslib.utils.errors.*;
import org.toxsoft.uskat.backend.sqlite.db.*;
import org.toxsoft.uskat.core.backend.*;
import org.toxsoft.uskat.core.backend.api.*;

/**
 * {@link IBaClobs} implementation.
 *
 * @author hazard157
 */
class BslBaClobs
    extends BslAbstractAddon
    implements IBaClobs {

  /**
   * Constructor.
   *
   * @param aOwner {@link BslBackend} - the owner backend
   * @param aDb {@link IDbDriver} - access to the Sqlite data file
   * @throws TsNullArgumentRtException any argument = <code>null</code>
   */
  BslBaClobs( BslBackend aOwner, IDbDriver aDb ) {
    super( aOwner, aDb, ISkBackendHardConstant.BAINF_CLOBS );
  }

  // ------------------------------------------------------------------------------------
  // IBaClobs
  //

  @Override
  public String readClob( Gwid aGwid ) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void writeClob( Gwid aGwid, String aClob ) {
    // TODO Auto-generated method stub

  }

}
