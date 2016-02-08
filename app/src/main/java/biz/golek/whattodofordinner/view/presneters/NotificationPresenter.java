package biz.golek.whattodofordinner.view.presneters;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;

import biz.golek.whattodofordinner.view.helpers.ViewState;

/**
 * Created by bg on 08.02.16.
 */
public class NotificationPresenter {

    private ViewState viewState;

    public NotificationPresenter(ViewState viewState) {
        this.viewState = viewState;
    }

    public void show(String message) {
        Activity currentActivity = viewState.getCurrentActivity();
        Context context = currentActivity.getApplication().getApplicationContext();
        Toast toast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
        toast.show();
    }

}
