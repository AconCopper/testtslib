package com.vabanshio.ttt.app.parts;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;

import ttt.ITttEngine;

public class TttBoard
    extends Canvas {

  ITttEngine engine;

  public TttBoard( Composite parent, ITttEngine aEngine ) {
    super( parent, SWT.NONE );
    int cellSize = (int)(Math.min( parent.getBounds().height, parent.getBounds().width ) * 0.25);
    int boardSize = (int)Math.min( parent.getBounds().height, parent.getBounds().width * 0.5 );
    int cellLetterHeight = cellSize / 2 - 10;
    int cellLetterWidth = cellSize / 2 - 10;
    setBackground( new Color( 0, 0, 222 ) );
    engine = aEngine;
    addPaintListener( new PaintListener() {

      @Override
      public void paintControl( PaintEvent e ) {
        // TODO почему нельзя переместить наверх
        // int cellSize = (int)(Math.min( parent.getBounds().height, parent.getBounds().width ) * 0.25);
        // int boardSize = (int)Math.min( parent.getBounds().height, parent.getBounds().width * 0.5 );
        // int cellLetterHeight = cellSize / 2 - 10;
        // int cellLetterWidth = cellSize / 2 - 10;
        for( int i = 1; i < 3; i++ ) {
          e.gc.drawLine( i * cellSize, 0, i * cellSize, boardSize );
        }
        for( int i = 1; i < 3; i++ ) {
          e.gc.drawLine( 0, i * cellSize, boardSize, i * cellSize );
        }
        for( int i = 0; i < 3; i++ ) {
          for( int j = 1; j < 4; j++ ) {
            e.gc.drawText( "x", cellLetterWidth + cellSize * i, cellLetterHeight + cellSize * (j - 1) );
            // e.gc.drawText( engine.getCellSign( i * 3 + j ), cellLetterWidth + cellSize * i, cellLetterHeight +
            // cellSize * (j - 1) );
          }
        }
      }
    } );
    addMouseListener( new MouseListener() {

      @Override
      public void mouseUp( MouseEvent e ) {
        // int xCellNumber = e.x / cellSize;
        // int yCellNumber = e.y / cellSize + 1;
        // engine.makeAMove( xCellNumber*3 + yCellNumber );
        // System.out.print( xCellNumber );
        // System.out.print( yCellNumber );
      }

      @Override
      public void mouseDown( MouseEvent e ) {
        // nop
      }

      @Override
      public void mouseDoubleClick( MouseEvent e ) {
        // nop
      }
    } );
  };

}
