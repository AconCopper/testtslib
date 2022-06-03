
package com.vabanshio.ttt.app.parts;

import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.e4.ui.model.application.ui.advanced.MPerspective;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.e4.ui.workbench.modeling.EPartService;

public class PerspectiveSwitch {

  @Inject
  EModelService modelService;
  @Inject
  EPartService  partService;
  @Inject
  MApplication  application;

  @Execute
  public void execute() {
    MUIElement element = modelService.find( "com.vabanshio.ttt.app.parts.Calculator", application );
    MPerspective perspective = modelService.getPerspectiveFor( element );
    partService.switchPerspective( perspective );
  }

}
