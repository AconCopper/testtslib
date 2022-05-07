package ttt;

import static org.toxsoft.core.tslib.utils.TsTestUtils.p;

import org.toxsoft.core.tslib.coll.primtypes.IIntMapEdit;
import org.toxsoft.core.tslib.coll.primtypes.impl.IntMap;

public class TTTEngine {

  String                DRAWTEXT  = "Draw!";
  String                XWONTEXT  = "X won the game!";
  String                OWONTEXT  = "O won the game!";
  IIntMapEdit<ETttCell> GameMap   = new IntMap<ETttCell>( 9 );
  EGameState            GameState = EGameState.X_MOVE;

  public IIntMapEdit<ETttCell> cellState() {
    return GameMap;
  }

  public EGameState gameState() {
    // TODO

    return GameState;
  }

  public void newGame() {
    GameMap.clear();
    GameState = EGameState.X_MOVE;
  }

  public void makeAMove( int ChangedCell ) {
    switch( GameState ) {
      case X_MOVE:
        GameMap.put( ChangedCell, ETttCell.X_SIGN );
      case O_MOVE:
        GameMap.put( ChangedCell, ETttCell.O_SIGN );
      case DRAW:
        p( DRAWTEXT );
      case X_WIN:
        p( XWONTEXT );
      case O_WIN:
        p( OWONTEXT );
    }
  }
}
