package biz.golek.whattodofordinner.view.contract.business.presneters;

import android.app.Activity;
import android.content.Intent;

import javax.inject.Inject;

import biz.golek.whattodofordinner.business.contract.controllers.presenters.ShowSettingsPresenter;
import biz.golek.whattodofordinner.view.activities.SettingsActivity;
import biz.golek.whattodofordinner.view.helpers.ViewState;

/**
 * Created by bg on 02.02.16.
 */
public class ShowSettingsPresenterImpl implements ShowSettingsPresenter {
    @Inject
    ViewState viewState;

    @Override
    public void Show() {
        Intent intent = new Intent(viewState.getCurrentActivity(), SettingsActivity.class);
    }
}
