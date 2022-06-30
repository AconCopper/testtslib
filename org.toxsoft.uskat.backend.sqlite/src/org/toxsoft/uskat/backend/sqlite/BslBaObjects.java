package org.toxsoft.uskat.backend.sqlite;

import org.toxsoft.core.tslib.coll.*;
import org.toxsoft.core.tslib.coll.primtypes.*;
import org.toxsoft.core.tslib.gw.skid.*;
import org.toxsoft.core.tslib.utils.errors.*;
import org.toxsoft.uskat.backend.sqlite.db.*;
import org.toxsoft.uskat.core.api.objserv.*;
import org.toxsoft.uskat.core.backend.*;
import org.toxsoft.uskat.core.backend.api.*;

/**
 * {@link IBaObjects} implementation.
 *
 * @author hazard157
 */
class BslBaObjects
    extends BslAbstractAddon
    implements IBaObjects {

  /**
   * Constructor.
   *
   * @param aOwner {@link BslBackend} - the owner backend
   * @param aDb {@link IDbDriver} - access to the Sqlite data file
   * @throws TsNullArgumentRtException any argument = <code>null</code>
   */
  BslBaObjects( BslBackend aOwner, IDbDriver aDb ) {
    super( aOwner, aDb, ISkBackendHardConstant.BAINF_OBJECTS );
  }

  // ------------------------------------------------------------------------------------
  // IBaObjects
  //

  @Override
  public IDtoObject findObject( Skid aSkid ) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public IList<IDtoObject> readObjects( IStringList aClassIds ) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public IList<IDtoObject> readObjectsByIds( ISkidList aSkids ) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void writeObjects( ISkidList aRemoveSkids, IList<IDtoObject> aUpdateObjects ) {
    // TODO Auto-generated method stub

  }

}
