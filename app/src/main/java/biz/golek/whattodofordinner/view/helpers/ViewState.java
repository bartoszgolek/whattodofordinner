package biz.golek.whattodofordinner.view.helpers;

import android.app.Activity;

/**
 * Created by Bartosz Gołek on 2016-02-03.
 */
public class ViewState {
    private Activity currentActivity;

    public Activity getCurrentActivity() {
        return currentActivity;
    }

    public void setCurrentActivity(Activity currentActivity) {
        this.currentActivity = currentActivity;
    }
}
