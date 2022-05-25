package ttt;

import static org.toxsoft.core.tslib.utils.TsTestUtils.pl;

import org.toxsoft.core.tslib.coll.primtypes.IIntMapEdit;
import org.toxsoft.core.tslib.coll.primtypes.impl.IntMap;

public class TTTEngine
    implements ITttEngine {

  String                     DRAWTEXT  = "Draw!";
  String                     XWONTEXT  = "X won the game!";
  String                     OWONTEXT  = "O won the game!";
  IIntMapEdit<ETttCellState> GameMap   = new IntMap<ETttCellState>( 9 );
  EGameState                 GameState = EGameState.X_MOVE;

  public TTTEngine() {
    for( int i = 0; i < 9; i++ ) {
      GameMap.put( i, ETttCellState.EMPTY );
    }
  }

  @Override
  public String getCellSign( int cell ) {
    ETttCellState cellstate = GameMap.getByKey( cell );
    switch( cellstate ) {
      case EMPTY: {
        return "-";
      }
      case O_SIGN: {
        return "O";
      }
      case X_SIGN: {
        return "X";
      }
      default:
        throw new IllegalArgumentException( "Unexpected value: " + cellstate );
    }
  }

  @Override
  public EGameState getGameState() {
    return GameState;
  }

  @Override
  public IIntMapEdit<ETttCellState> getGameMap() {
    return GameMap;
  }

  private boolean checkDraw() {
    return false;
  }

  private boolean checkWin( ETttCellState sign ) {
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

  @Override
  public EGameState gameState() {
    // TODO
    if( checkWin( ETttCellState.X_SIGN ) ) {
      GameState = EGameState.X_WIN;
      return GameState;
    }
    if( checkWin( ETttCellState.O_SIGN ) ) {
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

  @Override
  public void newGame() {
    GameMap.clear();
    GameState = EGameState.X_MOVE;
  }

  @Override
  public void makeAMove( int ChangedCell ) {
    switch( GameState ) {
      case X_MOVE:
        GameMap.put( ChangedCell, ETttCellState.X_SIGN );
        GameState = EGameState.O_MOVE;
        GameState = gameState();
        break;
      case O_MOVE:
        GameMap.put( ChangedCell, ETttCellState.O_SIGN );
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
