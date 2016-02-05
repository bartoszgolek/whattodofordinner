package biz.golek.whattodofordinner.business.contract.controllers;

import biz.golek.whattodofordinner.business.contract.request_data.SaveNewDinnerRequestData;
import biz.golek.whattodofordinner.view.view_models.Dinner;

/**
 * Created by bg on 05.02.16.
 */
public interface SaveNewDinnerController {
    void Run(Dinner requestData);
}
