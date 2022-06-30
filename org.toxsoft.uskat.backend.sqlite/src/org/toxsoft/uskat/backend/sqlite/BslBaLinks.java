package org.toxsoft.uskat.backend.sqlite;

import org.toxsoft.core.tslib.coll.*;
import org.toxsoft.core.tslib.coll.primtypes.*;
import org.toxsoft.core.tslib.gw.gwid.*;
import org.toxsoft.core.tslib.gw.skid.*;
import org.toxsoft.core.tslib.utils.errors.*;
import org.toxsoft.uskat.backend.sqlite.db.*;
import org.toxsoft.uskat.core.api.linkserv.*;
import org.toxsoft.uskat.core.backend.*;
import org.toxsoft.uskat.core.backend.api.*;

/**
 * {@link IBaLinks} implementation.
 *
 * @author hazard157
 */
class BslBaLinks
    extends BslAbstractAddon
    implements IBaLinks {

  /**
   * Constructor.
   *
   * @param aOwner {@link BslBackend} - the owner backend
   * @param aDb {@link IDbDriver} - access to the Sqlite data file
   * @throws TsNullArgumentRtException any argument = <code>null</code>
   */
  BslBaLinks( BslBackend aOwner, IDbDriver aDb ) {
    super( aOwner, aDb, ISkBackendHardConstant.BAINF_LINKS );
  }

  // ------------------------------------------------------------------------------------
  // IBaLinks
  //

  @Override
  public IDtoLinkFwd findLinkFwd( Gwid aLinkGwid, Skid aLeftSkid ) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public IList<IDtoLinkFwd> getAllLinksFwd( Skid aLeftSkid ) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public IDtoLinkRev findLinkRev( Gwid aLinkGwid, Skid aRightSkid, IStringList aLeftClassIds ) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public IMap<Gwid, IDtoLinkRev> getAllLinksRev( Skid aRightSkid ) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void writeLinksFwd( IList<IDtoLinkFwd> aLinks ) {
    // TODO Auto-generated method stub

  }

}
