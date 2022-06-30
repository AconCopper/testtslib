package org.toxsoft.uskat.backend.sqlite;

import static org.toxsoft.core.tslib.av.EAtomicType.*;
import static org.toxsoft.core.tslib.av.impl.AvUtils.*;
import static org.toxsoft.core.tslib.av.metainfo.IAvMetaConstants.*;
import static org.toxsoft.uskat.backend.sqlite.ISkResources.*;

import org.toxsoft.core.tslib.av.impl.*;
import org.toxsoft.core.tslib.av.metainfo.*;
import org.toxsoft.uskat.core.backend.*;

/**
 * BSL (<b>B</b>ackend <b>S</b>q<b>L</b>ite) backend constants.
 *
 * @author hazard157
 */
public interface IBackendSqliteConstants {

  /**
   * The backend ID.
   */
  String BACKEND_ID = ISkBackendHardConstant.SKB_ID + ".sqlite"; //$NON-NLS-1$

  /**
   * Backend arg: path to the file.
   */
  IDataDef OPDEF_FILE_PATH = DataDef.create( BACKEND_ID + ".FilePath", STRING, //$NON-NLS-1$
      TSID_NAME, STR_N_OP_FILE_PATH, //
      TSID_DESCRIPTION, STR_D_OP_FILE_PATH, //
      TSID_IS_MANDATORY, AV_TRUE //
  );

}
