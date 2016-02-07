package biz.golek.whattodofordinner.business.contract.controllers;

import biz.golek.whattodofordinner.business.contract.request_data.SaveNewDinnerRequestData;

/**
 * Created by bg on 05.02.16.
 */
public interface SaveNewDinnerController {
    void Run(SaveNewDinnerRequestData requestData);
}
