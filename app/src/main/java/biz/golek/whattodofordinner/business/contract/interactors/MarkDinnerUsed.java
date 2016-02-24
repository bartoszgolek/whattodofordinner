package biz.golek.whattodofordinner.business.contract.interactors;

import biz.golek.whattodofordinner.business.contract.request_data.MarkDinnerUsedRequestData;

/**
 * Created by Bartosz Gołek on 24.02.16.
 */
public interface MarkDinnerUsed {
    void Run(MarkDinnerUsedRequestData requestData);
}
