package ttt;

import static org.toxsoft.core.tslib.utils.TsTestUtils.pl;

import org.toxsoft.core.tslib.coll.primtypes.IIntMapEdit;
import org.toxsoft.core.tslib.coll.primtypes.impl.IntMap;

public class TTTEngine {

  String                DRAWTEXT  = "Draw!";
  String                XWONTEXT  = "X won the game!";
  String                OWONTEXT  = "O won the game!";
  IIntMapEdit<ETttCell> GameMap   = new IntMap<ETttCell>( 9 );
  EGameState            GameState = EGameState.X_MOVE;

  public TTTEngine() {
    for( int i = 0; i < 9; i++ ) {
      GameMap.put( i, ETttCell.EMPTY );
    }
  }

  public IIntMapEdit<ETttCell> cellState() {
    return GameMap;
  }

  private boolean checkDraw() {
    return false;
  }

  private boolean checkWin( ETttCell sign ) {
    // Vertical
    for( int i = 0; i < 3; i++ ) {
      if( sign == GameMap.findByKey( i + 0 ) && sign == GameMap.findByKey( i + 3 )
          && sign == GameMap.findByKey( i + 6 ) ) {
        return true;
      }
    }
    // Horizontal
    for( int i = 0; i < 3; i++ ) {
      if( sign == GameMap.findByKey( 0 + i * 3 ) && sign == GameMap.findByKey( 1 + i * 3 )
          && sign == GameMap.findByKey( 2 + i * 3 ) ) {
        return true;
      }
    }
    // Diagonal
    if( sign == GameMap.findByKey( 2 ) && sign == GameMap.findByKey( 4 ) && sign == GameMap.findByKey( 6 ) ) {
      return true;
    }
    if( sign == GameMap.findByKey( 0 ) && sign == GameMap.findByKey( 4 ) && sign == GameMap.findByKey( 8 ) ) {
      return true;
    }
    return false;

  }

  public EGameState gameState() {
    // TODO
    if( checkWin( ETttCell.X_SIGN ) ) {
      GameState = EGameState.X_WIN;
      return GameState;
    }
    if( checkWin( ETttCell.O_SIGN ) ) {
      GameState = EGameState.O_WIN;
      return GameState;
    }
    if( checkDraw() == true ) {
      GameState = EGameState.DRAW;
      return GameState;
    }
    else {
      return GameState;
    }
  }

  public void newGame() {
    GameMap.clear();
    GameState = EGameState.X_MOVE;
  }

  public void makeAMove( int ChangedCell ) {
    switch( GameState ) {
      case X_MOVE:
        GameMap.put( ChangedCell, ETttCell.X_SIGN );
        GameState = EGameState.O_MOVE;
        GameState = gameState();
        break;
      case O_MOVE:
        GameMap.put( ChangedCell, ETttCell.O_SIGN );
        GameState = EGameState.X_MOVE;
        GameState = gameState();
        break;
      case DRAW:
        pl( DRAWTEXT );
        break;
      case X_WIN:
        pl( XWONTEXT );
        break;
      case O_WIN:
        pl( OWONTEXT );
        break;
    }
  }
}
