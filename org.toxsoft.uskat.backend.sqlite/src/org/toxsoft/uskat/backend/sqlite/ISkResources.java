package org.toxsoft.uskat.backend.sqlite;

/**
 * Локализуемые ресурсы.
 *
 * @author hazard157
 */
@SuppressWarnings( "nls" )
interface ISkResources {

  /**
   * {@link IBackendSqliteConstants}
   */
  String STR_N_OP_FILE_PATH             = "Файл";
  String STR_D_OP_FILE_PATH             = "Файл для хранения БД Sqlite";
  String FMT_ERR_NO_FILE_NAME_SPECIFIED = "Не задан параметр %s: имя Sqlite файла хранения данных";

}
