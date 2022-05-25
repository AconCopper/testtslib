package com.vabanshio.ttt.app.parts;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.ui.di.Focus;
import org.eclipse.e4.ui.di.Persist;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

import ttt.ITttEngine;
import ttt.TTTEngine;

public class SamplePart {

  TttBoard tb;
  // TODO ITttEngine engine = new TTTENginge?
  // TTTEngine engine;
  ITttEngine engine;
  Button     b;

  private TableViewer tableViewer;

  @Inject
  private MPart part;

  @PostConstruct
  public void createComposite( Composite parent ) {
    engine = new TTTEngine();
    parent.setLayout( new GridLayout( 1, false ) );
    b = new Button( parent, SWT.PUSH );
    b.setText( "Reset game" );
    b.addSelectionListener( new SelectionListener() {

      @Override
      public void widgetSelected( SelectionEvent e ) {
        engine.newGame();
      }

      @Override
      public void widgetDefaultSelected( SelectionEvent e ) {
        // nop
      }
    } );
    // TextFactory.newText( SWT.BORDER ) //
    // .message( "Enter text to mark part as dirty" ) //
    // .onModify( e -> part.setDirty( true ) ) //
    // .layoutData( new GridData( GridData.FILL_HORIZONTAL ) )//
    // .create( parent );
    //
    // tableViewer = new TableViewer( parent );
    // tableViewer.getTable().setHeaderVisible( true );
    // tableViewer.setContentProvider( ArrayContentProvider.getInstance() );
    // tableViewer.setInput( createInitialDataModel() );
    // tableViewer.getTable().setLayoutData( new GridData( GridData.FILL_BOTH ) );
    engine = new TTTEngine();
    tb = new TttBoard( parent, engine );
    tb.setLayoutData( new GridData( GridData.FILL_BOTH ) );
  }

  @Focus
  public void setFocus() {
    tableViewer.getTable().setFocus();
  }

  @Persist
  public void save() {
    part.setDirty( false );
  }

  private List<String> createInitialDataModel() {
    return Arrays.asList( "Sample item 1", "Sample item 2", "Sample item 3", "Sample item 4", "Sample item 5" );
  }
}
