package biz.golek.whattodofordinner.business.controllers;

import biz.golek.whattodofordinner.business.contract.controllers.MarkDinnerUsedController;
import biz.golek.whattodofordinner.business.contract.interactors.MarkDinnerUsed;
import biz.golek.whattodofordinner.business.contract.request_data.MarkDinnerUsedRequestData;

/**
 * Created by Bartosz Gołek on 24.02.16.
 */
public class MarkDinnerUsedControllerImpl implements MarkDinnerUsedController {
    private MarkDinnerUsed interactor;

    public MarkDinnerUsedControllerImpl(MarkDinnerUsed interactor) {
        this.interactor = interactor;
    }

    @Override
    public void Run(MarkDinnerUsedRequestData requestData) {
        interactor.Run(requestData);
    }
}
