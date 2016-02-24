package biz.golek.whattodofordinner.view.presneters;

import android.app.Activity;

import biz.golek.whattodofordinner.view.helpers.ViewState;

/**
 * Created by Bartosz Gołek on 24.02.16.
 */
public class CloseCurrentActivityPresenter {
    private ViewState viewState;

    public CloseCurrentActivityPresenter(ViewState viewState) {
        this.viewState = viewState;
    }

    public void closeActivity()
    {
        Activity currentActivity = viewState.getCurrentActivity();
        currentActivity.finish();
    }
}
