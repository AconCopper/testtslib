package ttt;

import static org.toxsoft.core.tslib.utils.TsTestUtils.p;
import static org.toxsoft.core.tslib.utils.TsTestUtils.pl;
import static org.toxsoft.core.tslib.utils.TsTestUtils.waitEnter;

public class Main {

  public static void main( String[] Argz ) {
    TTTEngine eng = new TTTEngine();
    for( ; eng.GameState == eng.GameState.X_MOVE || eng.GameState == eng.GameState.O_MOVE; ) {
      pl( String.valueOf( eng.GameState ) );
      Integer moveNum = Integer.valueOf( waitEnter( "Ячейка хода?\n" ) );
      eng.makeAMove( moveNum );
      for( int i = 0; i < 9; i++ ) {
        p( String.valueOf( eng.GameMap.findByKey( i ) ) );
      }
      pl( "" );
      for( int i = 0; i < 3; i++ ) {
        for( int j = 0; j < 3; j++ ) {
          p( String.valueOf( eng.GameMap.findByKey( 3 * i + j ) ) + " " );
        }
        pl( "" );

      }
    }
  }
}
