package biz.golek.whattodofordinner.business.contract.interactors;

import biz.golek.whattodofordinner.business.contract.request_data.UpdateDinnerRequestData;

/**
 * Created by Bartosz Gołek on 2016-02-10.
 */
public interface UpdateDinnerController {
    void Run(UpdateDinnerRequestData requestData);
}
