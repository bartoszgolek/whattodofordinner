package biz.golek.whattodofordinner.business.controllers;

import biz.golek.whattodofordinner.business.contract.controllers.ShowMarkDinnerUsedController;
import biz.golek.whattodofordinner.business.contract.interactors.ShowMarkDinnerUsed;

/**
 * Created by Bartosz Gołek on 23.02.16.
 */
public class ShowMarkDinnerUsedControllerImpl implements ShowMarkDinnerUsedController {
    private ShowMarkDinnerUsed interactor;

    public ShowMarkDinnerUsedControllerImpl(ShowMarkDinnerUsed interactor) {
        this.interactor = interactor;
    }

    @Override
    public void Run() {
        interactor.Run();
    }
}
