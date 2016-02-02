package biz.golek.whattodofordinner;

import android.app.Activity;

/**
 * Created by bg on 02.02.16.
 */
public class WhatToDoForDinnerApp extends com.orm.SugarApp {
    public void onCreate() {
        super.onCreate();
    }

    private Activity mCurrentActivity = null;
    public Activity getCurrentActivity(){
        return mCurrentActivity;
    }
    public void setCurrentActivity(Activity mCurrentActivity){
        this.mCurrentActivity = mCurrentActivity;
    }
}
