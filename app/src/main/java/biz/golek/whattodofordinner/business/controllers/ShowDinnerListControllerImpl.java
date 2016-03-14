package biz.golek.whattodofordinner.business.controllers;

import biz.golek.whattodofordinner.business.contract.controllers.ShowDinnerListController;
import biz.golek.whattodofordinner.business.contract.interactors.ShowDinnerList;

/**
 * Created by Bartosz Gołek on 2016-02-08.
 */
public class ShowDinnerListControllerImpl implements ShowDinnerListController {
    private ShowDinnerList interactor;

    public ShowDinnerListControllerImpl(ShowDinnerList interactor) {
        this.interactor = interactor;
    }

    @Override
    public void Run() {
        interactor.Run();
    }
}
