package biz.golek.whattodofordinner.business.contract.controllers;

import biz.golek.whattodofordinner.business.contract.request_data.GeneratePromptsRequestData;

/**
 * Created by bg on 10.02.16.
 */
public interface GeneratePromptsController {
    void Run(GeneratePromptsRequestData requestData);
}
