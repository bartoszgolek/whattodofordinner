package biz.golek.whattodofordinner;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import javax.inject.Inject;

import biz.golek.whattodofordinner.view.ActivityDependencyProvider;
import biz.golek.whattodofordinner.view.awareness.IActivityDependencyProviderAware;

/**
 * Created by bg on 02.02.16.
 */
public class ActivityDependencyProviderInjector implements Application.ActivityLifecycleCallbacks {

    private ActivityDependencyProvider activityDependencyProvider;

    @Inject
    public ActivityDependencyProviderInjector(ActivityDependencyProvider activityDependencyProvider)
    {
        this.activityDependencyProvider = activityDependencyProvider;
    }

    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        if (activity instanceof IActivityDependencyProviderAware)
            ((IActivityDependencyProviderAware)activity).Set(activityDependencyProvider);
    }

    @Override
    public void onActivityStarted(Activity activity) {

    }

    @Override
    public void onActivityResumed(Activity activity) {

    }

    @Override
    public void onActivityPaused(Activity activity) {

    }

    @Override
    public void onActivityStopped(Activity activity) {

    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {

    }
}
