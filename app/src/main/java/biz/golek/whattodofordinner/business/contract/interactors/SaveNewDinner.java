package biz.golek.whattodofordinner.business.contract.interactors;

import biz.golek.whattodofordinner.business.contract.request_data.SaveNewDinnerRequestData;

/**
 * Created by bg on 05.02.16.
 */
public interface SaveNewDinner {
    void Run(SaveNewDinnerRequestData requestData);
}
