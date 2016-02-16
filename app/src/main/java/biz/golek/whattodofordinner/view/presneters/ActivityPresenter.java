package biz.golek.whattodofordinner.view.presneters;

import android.app.Activity;
import android.content.Intent;

import java.io.Serializable;

import biz.golek.whattodofordinner.view.helpers.ViewState;

/**
 * Created by Bartosz Gołek on 2016-02-08.
 */
public class ActivityPresenter {
    private ViewState viewState;

    public ActivityPresenter(ViewState viewState) {
        this.viewState = viewState;
    }

    public void startActivity(Class c)
    {
        Activity currentActivity = viewState.getCurrentActivity();
        Intent intent = new Intent(currentActivity, c);
        currentActivity.startActivity(intent);
    }

    public <T extends Serializable> void startActivity(Class c, T data)
    {
        Activity currentActivity = viewState.getCurrentActivity();
        Intent intent = new Intent(currentActivity, c);
        intent.putExtra("VIEW_MODEL", data);
        currentActivity.startActivity(intent);
    }
}
