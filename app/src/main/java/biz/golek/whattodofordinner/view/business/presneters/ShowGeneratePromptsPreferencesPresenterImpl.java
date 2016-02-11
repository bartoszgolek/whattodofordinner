package biz.golek.whattodofordinner.view.business.presneters;

import biz.golek.whattodofordinner.business.contract.presenters.ShowGeneratePromptsPreferencesPresenter;
import biz.golek.whattodofordinner.view.activities.GeneratePromptsPreferencesActivity;
import biz.golek.whattodofordinner.view.presneters.ActivityPresenter;

/**
 * Created by bg on 10.02.16.
 */
public class ShowGeneratePromptsPreferencesPresenterImpl implements ShowGeneratePromptsPreferencesPresenter {
    private ActivityPresenter starter;

    public ShowGeneratePromptsPreferencesPresenterImpl(ActivityPresenter starter) {
        this.starter = starter;
    }

    @Override
    public void Show() {
        starter.startActivity(GeneratePromptsPreferencesActivity.class);
    }
}
