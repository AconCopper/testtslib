package org.toxsoft.uskat.backend.sqlite.db;

import java.io.*;

import org.toxsoft.core.tslib.bricks.strid.coll.*;
import org.toxsoft.uskat.core.api.sysdescr.dto.*;

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
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void writeClassInfos( IStridablesList<IDtoClassInfo> aClassInfos ) {
    // TODO Auto-generated method stub

  }

}
