package biz.golek.whattodofordinner.view.presneters;

import biz.golek.whattodofordinner.business.contract.presenters.GeneratePromptsPresenter;
import biz.golek.whattodofordinner.business.contract.response_data.GeneratePromptResponseData;
import biz.golek.whattodofordinner.view.activities.EmptyPromptsActivity;
import biz.golek.whattodofordinner.view.activities.PromptsActivity;
import biz.golek.whattodofordinner.view.view_models.PromptsActivityViewModel;

/**
 * Created by bg on 10.02.16.
 */
public class GeneratePromptsPresenterImpl implements GeneratePromptsPresenter {
    private ActivityPresenter activityPresenter;

    public GeneratePromptsPresenterImpl(ActivityPresenter activityPresenter) {
        this.activityPresenter = activityPresenter;
    }

    @Override
    public void Show(GeneratePromptResponseData responseData) {
        PromptsActivityViewModel data = new PromptsActivityViewModel();
        data.setPrompts(responseData.getPrompts());
        data.setExcludes(responseData.getExcludes());
        data.setMaximumDuration(responseData.getMaximumDuration());
        data.setSoupProfile(responseData.getSoupProfile());
        data.setVegetarianProfile(responseData.getVegetarianProfile());
        activityPresenter.startActivity(PromptsActivity.class, data);
    }

    @Override
    public void ShowEmptyResult() {
        activityPresenter.startActivity(EmptyPromptsActivity.class);
    }
}
