package biz.golek.whattodofordinner.business.interactors;

import biz.golek.whattodofordinner.business.contract.interactors.ShowGeneratePromptsPreferences;
import biz.golek.whattodofordinner.business.contract.presenters.ShowGeneratePromptsPreferencesPresenter;

/**
 * Created by bg on 10.02.16.
 */
public class ShowGeneratePromptsPreferencesImpl implements ShowGeneratePromptsPreferences {

    private ShowGeneratePromptsPreferencesPresenter presenter;

    public ShowGeneratePromptsPreferencesImpl(ShowGeneratePromptsPreferencesPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void Run() {
        presenter.Show();
    }
}
