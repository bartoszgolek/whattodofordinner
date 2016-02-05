package biz.golek.whattodofordinner.view.business.presneters;

import android.app.Activity;
import android.content.Intent;

import biz.golek.whattodofordinner.business.contract.presenters.AddNewDinnerPresenter;
import biz.golek.whattodofordinner.view.activities.AddNewDinnerActivity;
import biz.golek.whattodofordinner.view.helpers.ViewState;

/**
 * Created by bgolek on 2016-02-05.
 */
public class AddNewDinnerPresenterImpl implements AddNewDinnerPresenter {
    private ViewState viewState;

    public AddNewDinnerPresenterImpl(ViewState viewState) {
        this.viewState = viewState;
    }

    @Override
    public void Run() {
        Activity currentActivity = viewState.getCurrentActivity();
        Intent intent = new Intent(currentActivity, AddNewDinnerActivity.class);
        currentActivity.startActivity(intent);
    }
}
