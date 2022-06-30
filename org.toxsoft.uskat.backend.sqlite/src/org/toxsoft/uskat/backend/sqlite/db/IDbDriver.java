package org.toxsoft.uskat.backend.sqlite.db;

import java.io.*;

import org.toxsoft.core.tslib.bricks.strid.coll.*;
import org.toxsoft.core.tslib.utils.*;
import org.toxsoft.core.tslib.utils.errors.*;
import org.toxsoft.uskat.core.api.sysdescr.dto.*;

/**
 * Driver to work with Sqlite database.
 *
 * @author hazard157
 */
public interface IDbDriver
    extends ICloseable {

  /**
   * Initializes driver to work with the sepcified file.
   * <p>
   * If file does not exists, creates it populates with neccessary tables.
   *
   * @param aSqliteFile {@link File} - SQlite database file
   */
  void init( File aSqliteFile );

  // ------------------------------------------------------------------------------------
  // Classes

  /**
   * Reads all classes from the database at once.
   *
   * @return {@link IStridablesList}&lt;{@link IDtoClassInfo}&gt; - list of infos of all classes
   */
  IStridablesList<IDtoClassInfo> loadClassInfos();

  /**
   * Writes all classes to the database at once.
   *
   * @param aClassInfos {@link IStridablesList}&lt;{@link IDtoClassInfo}&gt; - list of infos of all classes
   * @throws TsNullArgumentRtException any argument = <code>null</code>
   */
  void writeClassInfos( IStridablesList<IDtoClassInfo> aClassInfos );

}
