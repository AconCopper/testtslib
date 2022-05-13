package ttt;

import static org.toxsoft.core.tslib.utils.TsTestUtils.p;
import static org.toxsoft.core.tslib.utils.TsTestUtils.pl;
import static org.toxsoft.core.tslib.utils.TsTestUtils.waitEnter;

public class Main {

  public static String swapCellStateToCellSign( ETttCellState cellstate ) {
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

  public static void main( String[] Argz ) {
    ITttEngine eng = new TTTEngine();
    for( ; eng.getGameState() == EGameState.X_MOVE || eng.getGameState() == EGameState.O_MOVE; ) {
      pl( String.valueOf( eng.getGameState() ) );
      Integer moveNum = Integer.valueOf( waitEnter( "Ячейка хода?\n" ) );
      eng.makeAMove( moveNum );
      for( int i = 0; i < 3; i++ ) {
        for( int j = 0; j < 3; j++ ) {
          p( swapCellStateToCellSign( eng.getGameMap().findByKey( 3 * i + j ) ) );
        }
        pl( "" );
      }
      switch( eng.getGameState() ) {
        case X_WIN: {
          pl( "X won" );
          break;
        }
        case O_WIN: {
          pl( "O won" );
          break;
        }
        case DRAW: {
          pl( "Draw" );
          break;
        }
        default:
      }
    }
  }
}
