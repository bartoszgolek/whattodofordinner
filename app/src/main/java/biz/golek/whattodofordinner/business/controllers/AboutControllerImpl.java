package biz.golek.whattodofordinner.business.controllers;

import biz.golek.whattodofordinner.business.contract.controllers.AboutController;
import biz.golek.whattodofordinner.business.contract.interactors.About;

/**
 * Created by bg on 12.02.16.
 */
public class AboutControllerImpl implements AboutController {
    private About interactor;

    public AboutControllerImpl(About interactor) {
        this.interactor = interactor;
    }

    @Override
    public void Run() {
        interactor.Run();
    }
}
