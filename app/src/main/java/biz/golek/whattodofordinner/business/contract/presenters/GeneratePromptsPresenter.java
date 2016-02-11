package biz.golek.whattodofordinner.business.contract.presenters;

import java.util.List;

import biz.golek.whattodofordinner.business.contract.response_data.DinnerListItem;
import biz.golek.whattodofordinner.business.contract.response_data.GeneratePromptResponseData;

/**
 * Created by bg on 10.02.16.
 */
public interface GeneratePromptsPresenter {
    void Show(GeneratePromptResponseData generatePromptResponseData);

    void ShowEmptyResult();
}
