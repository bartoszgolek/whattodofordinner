package biz.golek.whattodofordinner.business.contract.controllers;

import biz.golek.whattodofordinner.business.contract.request_data.MarkDinnerUsedRequestData;

/**
 * Created by Bartosz Gołek on 24.02.16.
 */
public interface MarkDinnerUsedController {
    void Run(MarkDinnerUsedRequestData requestData);
}
