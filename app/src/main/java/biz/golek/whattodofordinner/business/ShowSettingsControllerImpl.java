package biz.golek.whattodofordinner.business;

import javax.inject.Inject;

import biz.golek.whattodofordinner.business.contract.controllers.ShowSettingsController;
import biz.golek.whattodofordinner.business.contract.controllers.interactors.ShowSettings;

/**
 * Created by bg on 02.02.16.
 */
public class ShowSettingsControllerImpl implements ShowSettingsController {

    @Inject
    ShowSettings interactor;

    @Override
    public void Run() {
        interactor.Run();
    }
}
