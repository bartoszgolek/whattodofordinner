package biz.golek.whattodofordinner;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by bg on 02.02.16.
 */
public class BaseActivity extends Activity {
    protected WhatToDoForDinnerApp mMyApp;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMyApp = (WhatToDoForDinnerApp)this.getApplicationContext();
    }
    protected void onResume() {
        super.onResume();
        mMyApp.setCurrentActivity(this);
    }
    protected void onPause() {
        clearReferences();
        super.onPause();
    }
    protected void onDestroy() {
        clearReferences();
        super.onDestroy();
    }

    private void clearReferences(){
        Activity currActivity = mMyApp.getCurrentActivity();
        if (this.equals(currActivity))
            mMyApp.setCurrentActivity(null);
    }
}
