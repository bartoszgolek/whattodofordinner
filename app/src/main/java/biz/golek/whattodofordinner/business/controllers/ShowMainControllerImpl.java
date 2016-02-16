package biz.golek.whattodofordinner.business.controllers;

import biz.golek.whattodofordinner.business.contract.controllers.ShowMainController;
import biz.golek.whattodofordinner.business.contract.interactors.ShowMain;

/**
 * Created by Bartosz Gołek on 2016-02-11.
 */
public class ShowMainControllerImpl implements ShowMainController {
    private ShowMain interactor;

    public ShowMainControllerImpl(ShowMain interactor) {
        this.interactor = interactor;
    }

    @Override
    public void Run() {
        interactor.Run();
    }
}
