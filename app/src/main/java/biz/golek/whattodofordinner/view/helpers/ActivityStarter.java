package biz.golek.whattodofordinner.view.helpers;

import android.app.Activity;
import android.content.Intent;

import java.io.Serializable;

import biz.golek.whattodofordinner.view.activities.AddNewDinnerActivity;

/**
 * Created by bgolek on 2016-02-08.
 */
public class ActivityStarter {
    private ViewState viewState;

    public ActivityStarter(ViewState viewState) {
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
