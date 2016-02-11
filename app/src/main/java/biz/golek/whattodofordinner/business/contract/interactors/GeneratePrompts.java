package biz.golek.whattodofordinner.business.contract.interactors;

import biz.golek.whattodofordinner.business.contract.request_data.GeneratePromptsRequestData;

/**
 * Created by bg on 10.02.16.
 */
public interface GeneratePrompts {
    void Run(GeneratePromptsRequestData requestData);
}
