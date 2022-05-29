package com.vabanshio.ttt.app.parts;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.toxsoft.core.tslib.bricks.events.change.IGenericChangeListener;

import ttt.ITttEngine;

public class TttBoard
    extends Canvas {

  ITttEngine engine;

  public TttBoard( Composite parent, ITttEngine aEngine ) {
    super( parent, SWT.NONE );
    setBackground( new Color( 0, 0, 222 ) );
    engine = aEngine;
    engine.addListener( new IGenericChangeListener() {

      @Override
      public void onGenericChangeEvent( Object aSource ) {
        parent.redraw();
      }
    } );

    addPaintListener( new PaintListener() {

      @Override
      public void paintControl( PaintEvent e ) {
        int cellSize = (int)(Math.min( parent.getBounds().height, parent.getBounds().width ) * 0.25);
        int boardSize = (int)Math.min( parent.getBounds().height, parent.getBounds().width * 0.5 );
        int cellLetterHeight = cellSize / 2 - 10;
        int cellLetterWidth = cellSize / 2 - 10;
        for( int i = 1; i < 3; i++ ) {
          e.gc.drawLine( i * cellSize, 0, i * cellSize, boardSize );
        }
        for( int i = 1; i < 3; i++ ) {
          e.gc.drawLine( 0, i * cellSize, boardSize, i * cellSize );
        }
        for( int i = 0; i < 3; i++ ) {
          for( int j = 0; j < 3; j++ ) {
            // e.gc.drawText( "x", cellLetterWidth + cellSize * i, cellLetterHeight + cellSize * (j - 1) );
            e.gc.drawText( engine.getCellSign( i * 3 + j ), cellLetterWidth + cellSize * i,
                cellLetterHeight + cellSize * (j) );
          }
        }
      }
    } );
    addMouseListener( new MouseListener() {

      @Override
      public void mouseUp( MouseEvent e ) {
        int cellSize = (int)(Math.min( parent.getBounds().height, parent.getBounds().width ) * 0.25);
        int xCellNumber = e.x / cellSize;
        int yCellNumber = e.y / cellSize;
        engine.makeAMove( xCellNumber * 3 + yCellNumber );
        // System.out.print( xCellNumber );
        // System.out.print( yCellNumber );
        System.out.print( engine.getGameState() );
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
  }

}
