package org.toxsoft.uskat.backend.sqlite;

import org.toxsoft.core.tslib.bricks.*;
import org.toxsoft.core.tslib.bricks.strid.*;
import org.toxsoft.core.tslib.utils.*;
import org.toxsoft.core.tslib.utils.errors.*;
import org.toxsoft.uskat.backend.sqlite.db.*;
import org.toxsoft.uskat.core.backend.api.*;

/**
 * Base implementation of {@link IBackendAddon} for Sqlite backend.
 *
 * @author hazard157
 */
public class BslAbstractAddon
    extends BackendAddonBase<BslBackend>
    implements IInitializable, ICloseable {

  private final IDbDriver db;

  /**
   * Constructor for subclasses.
   *
   * @param aOwner {@link BslBackend} - the owner backend
   * @param aDb {@link IDbDriver} - access to the Sqlite data file
   * @param aInfo {@link IStridable} - the addon info
   * @throws TsNullArgumentRtException any argument = <code>null</code>
   */
  protected BslAbstractAddon( BslBackend aOwner, IDbDriver aDb, IStridable aInfo ) {
    super( aOwner, aInfo );
    db = TsNullArgumentRtException.checkNull( aDb );
  }

  // ------------------------------------------------------------------------------------
  // IInitializable
  //

  @Override
  public void initialize() {
    // nop
  }

  // ------------------------------------------------------------------------------------
  // ICloseable
  //

  @Override
  public void close() {
    // nop
  }

  // ------------------------------------------------------------------------------------
  // For subclasses
  //

  /**
   * Returns Sqlite data access
   *
   * @return {@link IDbDriver} - Sqlite database access means
   */
  public IDbDriver db() {
    return db;
  }

}
