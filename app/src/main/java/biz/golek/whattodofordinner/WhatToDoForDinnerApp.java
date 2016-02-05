package biz.golek.whattodofordinner;

import biz.golek.whattodofordinner.business.contract.interactors.AddNewDinner;
import biz.golek.whattodofordinner.modules.AddNewDinnerModule;
import biz.golek.whattodofordinner.modules.AppModule;
import biz.golek.whattodofordinner.modules.SettingsModule;
import biz.golek.whattodofordinner.view.ControllersProvider;

/**
 * Created by bg on 02.02.16.
 */
public class WhatToDoForDinnerApp extends com.orm.SugarApp {

    @Override
    public void onCreate() {
        super.onCreate();

        ApplicationComponent component = DaggerApplicationComponent.builder()
                .appModule(new AppModule())
                .settingsModule(new SettingsModule())
                .addNewDinnerModule(new AddNewDinnerModule())
                .build();

        registerActivityLifecycleCallbacks(component.viewStateManager());
        registerActivityLifecycleCallbacks(component.controllersProviderInjector());
    }
}
