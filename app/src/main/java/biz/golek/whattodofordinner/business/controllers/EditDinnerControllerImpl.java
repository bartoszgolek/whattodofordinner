package biz.golek.whattodofordinner.business.controllers;

import biz.golek.whattodofordinner.business.contract.controllers.EditDinnerController;
import biz.golek.whattodofordinner.business.contract.interactors.EditDinner;

/**
 * Created by bgolek on 2016-02-10.
 */
public class EditDinnerControllerImpl implements EditDinnerController {
    private EditDinner editDinner;

    public EditDinnerControllerImpl(EditDinner editDinner) {
        this.editDinner = editDinner;
    }

    @Override
    public void Run(Long id) {
        editDinner.Run(id);
    }
}
