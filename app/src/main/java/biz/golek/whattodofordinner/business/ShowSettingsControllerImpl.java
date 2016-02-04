package biz.golek.whattodofordinner.business;

import javax.inject.Inject;

import biz.golek.whattodofordinner.business.contract.controllers.ShowSettingsController;
import biz.golek.whattodofordinner.business.contract.controllers.interactors.ShowSettings;

/**
 * Created by bg on 02.02.16.
 */
public class ShowSettingsControllerImpl implements ShowSettingsController {

    ShowSettings interactor;

    @Inject
    public ShowSettingsControllerImpl(ShowSettings showSettings){
        this.interactor = showSettings;
    }

    @Override
    public void Run() {
        interactor.Run();
    }
}
