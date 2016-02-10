package biz.golek.whattodofordinner.business.contract.interactors;

import biz.golek.whattodofordinner.business.contract.request_data.UpdateDinnerRequestData;

/**
 * Created by bgolek on 2016-02-10.
 */
public interface UpdateDinner {
    void Run(UpdateDinnerRequestData requestData);
}
