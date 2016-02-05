package biz.golek.whattodofordinner.business.interactors;

import javax.inject.Inject;

import biz.golek.whattodofordinner.business.contract.interactors.ShowSettings;
import biz.golek.whattodofordinner.business.contract.presenters.ShowSettingsPresenter;

/**
 * Created by bg on 02.02.16.
 */
public class ShowSettingsImpl implements ShowSettings {

    @Inject
    public ShowSettingsImpl(ShowSettingsPresenter presenter){
        this.presenter = presenter;
    }

    ShowSettingsPresenter presenter;

    @Override
    public void Run() {
        presenter.Show();
    }
}
