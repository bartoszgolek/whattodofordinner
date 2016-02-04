package biz.golek.whattodofordinner;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import javax.inject.Inject;

import biz.golek.whattodofordinner.view.ControllersProvider;
import biz.golek.whattodofordinner.view.awareness.IAware;
import biz.golek.whattodofordinner.view.awareness.IControllersProviderAware;

/**
 * Created by bg on 02.02.16.
 */
public class ControllersProviderInjector implements Application.ActivityLifecycleCallbacks {

    private ControllersProvider controllersProvider;

    @Inject
    public ControllersProviderInjector(ControllersProvider controllersProvider)
    {
        this.controllersProvider = controllersProvider;
    }

    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        if (activity instanceof IControllersProviderAware)
            ((IControllersProviderAware)activity).Set(controllersProvider);
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
