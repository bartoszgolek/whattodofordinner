package biz.golek.whattodofordinner.view.business.presneters;

import android.app.Activity;
import android.content.Intent;

import javax.inject.Inject;

import biz.golek.whattodofordinner.business.contract.presenters.ShowSettingsPresenter;
import biz.golek.whattodofordinner.view.activities.SettingsActivity;
import biz.golek.whattodofordinner.view.helpers.ViewState;

/**
 * Created by bg on 02.02.16.
 */
public class ShowSettingsPresenterImpl implements ShowSettingsPresenter {
    @Inject
    public ShowSettingsPresenterImpl(ViewState viewState){
        this.viewState = viewState;
    }

    ViewState viewState;

    @Override
    public void Show() {
        Activity currentActivity = viewState.getCurrentActivity();
        Intent intent = new Intent(currentActivity, SettingsActivity.class);
        currentActivity.startActivity(intent);
    }
}
