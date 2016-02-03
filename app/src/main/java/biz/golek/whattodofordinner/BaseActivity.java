package biz.golek.whattodofordinner;

import android.app.Activity;
import android.os.Bundle;

import javax.inject.Inject;

import biz.golek.whattodofordinner.view.helpers.ViewState;

/**
 * Created by bg on 02.02.16.
 */
public class BaseActivity extends Activity {
    @Inject
    ViewState viewState;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    protected void onResume() {
        super.onResume();
        viewState.setCurrentActivity(this);
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
        Activity currActivity = viewState.getCurrentActivity();
        if (this.equals(currActivity))
            viewState.setCurrentActivity(null);
    }
}
