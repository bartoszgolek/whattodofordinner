package biz.golek.whattodofordinner;

import android.app.Application;

import biz.golek.whattodofordinner.modules.DatabaseModule;
import biz.golek.whattodofordinner.modules.DinnerListModule;
import biz.golek.whattodofordinner.modules.NewDinnerModule;
import biz.golek.whattodofordinner.modules.AppModule;

/**
 * Created by bg on 02.02.16.
 */
public class WhatToDoForDinnerApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        ApplicationComponent component = DaggerApplicationComponent.builder()
                .appModule(new AppModule())
                .databaseModule(new DatabaseModule())
                .newDinnerModule(new NewDinnerModule())
                .dinnerListModule(new DinnerListModule())
                .build();

        registerActivityLifecycleCallbacks(component.viewStateManager());
        registerActivityLifecycleCallbacks(component.activityDependencyProviderInjector());
    }
}
