package org.toxsoft.uskat.backend.sqlite;

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

}
