package biz.golek.whattodofordinner;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import javax.inject.Inject;

import biz.golek.whattodofordinner.view.helpers.ViewState;

/**
 * Created by bg on 02.02.16.
 */
public class ViewStateManager implements Application.ActivityLifecycleCallbacks {

    private ViewState viewState;

    @Inject
    public ViewStateManager(ViewState viewState){
        this.viewState = viewState;
    }

    private void clearReferences(Activity activity){
        Activity currentActivity = viewState.getCurrentActivity();
        if (activity.equals(currentActivity))
            viewState.setCurrentActivity(null);
    }

    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {

    }

    @Override
    public void onActivityStarted(Activity activity) {

    }

    @Override
    public void onActivityResumed(Activity activity) {
        viewState.setCurrentActivity(activity);
    }

    @Override
    public void onActivityPaused(Activity activity) {
        clearReferences(activity);
    }

    @Override
    public void onActivityStopped(Activity activity) {

    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {
        clearReferences(activity);
    }
}
