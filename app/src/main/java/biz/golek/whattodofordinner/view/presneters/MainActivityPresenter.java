package biz.golek.whattodofordinner.view.presneters;

import android.app.Activity;
import android.content.Intent;

import biz.golek.whattodofordinner.MainActivity;
import biz.golek.whattodofordinner.view.helpers.ViewState;

/**
 * Created by bg on 11.02.16.
 */
public class MainActivityPresenter {
    private ViewState viewState;

    public MainActivityPresenter(ViewState viewState) {
        this.viewState = viewState;
    }

    public void startActivity()
    {
        Activity currentActivity = viewState.getCurrentActivity();
        Intent intent = new Intent(currentActivity, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        currentActivity.startActivity(intent);
    }
}
