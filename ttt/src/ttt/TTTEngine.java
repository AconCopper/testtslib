package ttt;

import static org.toxsoft.core.tslib.utils.TsTestUtils.pl;

import org.toxsoft.core.tslib.bricks.events.change.IGenericChangeListener;
import org.toxsoft.core.tslib.coll.IListEdit;
import org.toxsoft.core.tslib.coll.impl.ElemArrayList;
import org.toxsoft.core.tslib.coll.primtypes.IIntMapEdit;
import org.toxsoft.core.tslib.coll.primtypes.impl.IntMap;

public class TTTEngine
    implements ITttEngine {

  String                            DRAWTEXT      = "Draw!";
  String                            XWONTEXT      = "X won the game!";
  String                            OWONTEXT      = "O won the game!";
  IIntMapEdit<ETttCellState>        gameMap       = new IntMap<ETttCellState>();
  EGameState                        gameState     = EGameState.X_MOVE;
  IListEdit<IGenericChangeListener> listenersList = new ElemArrayList<IGenericChangeListener>();

  public TTTEngine() {
    for( int i = 0; i < 9; i++ ) {
      gameMap.put( i, ETttCellState.EMPTY );
    }
  }

  // TODO label
  // TODO добавить перспективу с калькулятором. Как переключать перспективу
  private void fireEvent() {
    for( IGenericChangeListener igcl : listenersList ) {
      igcl.onGenericChangeEvent( igcl );
    }
  }

  @Override
  public void addListener( IGenericChangeListener aListener ) {
    listenersList.add( aListener );
  }

  @Override
  public String getCellSign( int cell ) {
    ETttCellState cellstate = gameMap.getByKey( cell );
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
    return gameState;
  }

  @Override
  public IIntMapEdit<ETttCellState> getGameMap() {
    return gameMap;
  }

  private boolean checkDraw() {
    return false;
  }

  private boolean checkWin( ETttCellState sign ) {
    // Vertical
    for( int i = 0; i < 3; i++ ) {
      if( sign == gameMap.findByKey( i + 0 ) && sign == gameMap.findByKey( i + 3 )
          && sign == gameMap.findByKey( i + 6 ) ) {
        return true;
      }
    }
    // Horizontal
    for( int i = 0; i < 3; i++ ) {
      if( sign == gameMap.findByKey( 0 + i * 3 ) && sign == gameMap.findByKey( 1 + i * 3 )
          && sign == gameMap.findByKey( 2 + i * 3 ) ) {
        return true;
      }
    }
    // Diagonal
    if( sign == gameMap.findByKey( 2 ) && sign == gameMap.findByKey( 4 ) && sign == gameMap.findByKey( 6 ) ) {
      return true;
    }
    if( sign == gameMap.findByKey( 0 ) && sign == gameMap.findByKey( 4 ) && sign == gameMap.findByKey( 8 ) ) {
      return true;
    }
    return false;

  }

  @Override
  public EGameState gameState() {
    if( checkWin( ETttCellState.X_SIGN ) ) {
      gameState = EGameState.X_WIN;
      fireEvent();
      return gameState;
    }
    if( checkWin( ETttCellState.O_SIGN ) ) {
      gameState = EGameState.O_WIN;
      fireEvent();
      return gameState;
    }
    if( checkDraw() == true ) {
      gameState = EGameState.DRAW;
      fireEvent();
      return gameState;
    }
    else {
      fireEvent();
      return gameState;
    }
  }

  @Override
  public void newGame() {
    for( int i = 0; i < 9; i++ ) {
      gameMap.put( i, ETttCellState.EMPTY );
    }
    gameState = EGameState.X_MOVE;
    fireEvent();

  }

  @Override
  public void makeAMove( int ChangedCell ) {
    switch( gameState ) {
      case X_MOVE:
        gameMap.put( ChangedCell, ETttCellState.X_SIGN );
        gameState = EGameState.O_MOVE;
        gameState = gameState();
        break;
      case O_MOVE:
        gameMap.put( ChangedCell, ETttCellState.O_SIGN );
        gameState = EGameState.X_MOVE;
        gameState = gameState();
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
    fireEvent();
  }
}
