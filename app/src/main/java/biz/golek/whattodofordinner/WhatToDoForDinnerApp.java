package biz.golek.whattodofordinner;

import android.app.Application;

import biz.golek.whattodofordinner.models.DaoMaster;
import biz.golek.whattodofordinner.modules.DatabaseModule;
import biz.golek.whattodofordinner.modules.DinnerListModule;
import biz.golek.whattodofordinner.modules.NewDinnerModule;
import biz.golek.whattodofordinner.modules.AppModule;
import biz.golek.whattodofordinner.modules.SettingsModule;

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
                .settingsModule(new SettingsModule())
                .newDinnerModule(new NewDinnerModule())
                .dinnerListModule(new DinnerListModule())
                .build();

        registerActivityLifecycleCallbacks(component.viewStateManager());
        registerActivityLifecycleCallbacks(component.controllersProviderInjector());
    }
}
