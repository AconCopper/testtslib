package ttt;

import org.toxsoft.core.tslib.coll.primtypes.IIntMapEdit;

public interface ITttEngine {

  public IIntMapEdit<ETttCellState> getGameMap();

  public EGameState gameState();

  public void newGame();

  public void makeAMove( int ChangedCell );

  public EGameState getGameState();

}
