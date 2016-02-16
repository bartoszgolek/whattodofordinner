package biz.golek.whattodofordinner.business.controllers;

import biz.golek.whattodofordinner.business.contract.controllers.DinnerListController;
import biz.golek.whattodofordinner.business.contract.interactors.DinnerList;

/**
 * Created by Bartosz Gołek on 2016-02-08.
 */
public class DinnerListControllerImpl implements DinnerListController {
    private DinnerList interactor;

    public DinnerListControllerImpl(DinnerList interactor) {
        this.interactor = interactor;
    }

    @Override
    public void Run() {
        interactor.Run();
    }
}
