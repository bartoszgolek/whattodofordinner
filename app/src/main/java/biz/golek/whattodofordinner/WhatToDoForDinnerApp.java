package biz.golek.whattodofordinner;

import biz.golek.whattodofordinner.modules.AppModule;
import biz.golek.whattodofordinner.modules.SettingsModule;

/**
 * Created by bg on 02.02.16.
 */
public class WhatToDoForDinnerApp extends com.orm.SugarApp {
    private ApplicationComponent mComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mComponent = DaggerApplicationComponent.builder()
                .appModule(new AppModule())
                .settingsModule(new SettingsModule())
                .build();
    }

    public ApplicationComponent getComponent() {
        return mComponent;
    }
}
