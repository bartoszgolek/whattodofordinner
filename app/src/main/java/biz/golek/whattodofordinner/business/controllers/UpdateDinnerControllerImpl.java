package biz.golek.whattodofordinner.business.controllers;

import biz.golek.whattodofordinner.business.contract.interactors.UpdateDinner;
import biz.golek.whattodofordinner.business.contract.interactors.UpdateDinnerController;
import biz.golek.whattodofordinner.business.contract.request_data.UpdateDinnerRequestData;

/**
 * Created by Bartosz Gołek on 2016-02-10.
 */
public class UpdateDinnerControllerImpl implements UpdateDinnerController {
    private UpdateDinner updateDinner;

    public UpdateDinnerControllerImpl(UpdateDinner updateDinner) {
        this.updateDinner = updateDinner;
    }

    @Override
    public void Run(UpdateDinnerRequestData requestData) {
        updateDinner.Run(requestData);
    }
}
