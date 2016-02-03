package biz.golek.whattodofordinner;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import javax.inject.Inject;

import biz.golek.whattodofordinner.modules.AppModule;
import biz.golek.whattodofordinner.modules.SettingsModule;
import biz.golek.whattodofordinner.view.helpers.ViewState;

/**
 * Created by bg on 02.02.16.
 */
public class ActivityInjector implements Application.ActivityLifecycleCallbacks {
    private ApplicationComponent component;

    public ActivityInjector(){
        this.component = DaggerApplicationComponent.builder()
                .appModule(new AppModule())
                .settingsModule(new SettingsModule())
                .build();
    }

    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        component.inject(activity);
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
