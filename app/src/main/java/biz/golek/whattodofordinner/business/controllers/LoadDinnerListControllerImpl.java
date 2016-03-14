package biz.golek.whattodofordinner.business.controllers;

import biz.golek.whattodofordinner.business.contract.controllers.LoadDinnerListController;
import biz.golek.whattodofordinner.business.contract.interactors.LoadDinnerList;

/**
 * Created by bg on 14.03.16.
 */
public class LoadDinnerListControllerImpl implements LoadDinnerListController {
    private LoadDinnerList interactor;

    public LoadDinnerListControllerImpl(LoadDinnerList interactor) {
        this.interactor = interactor;
    }

    @Override
    public void run() {
        interactor.run();
    }
}
