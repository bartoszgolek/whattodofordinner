package biz.golek.whattodofordinner.view.business.presneters;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.widget.Toast;

import biz.golek.whattodofordinner.R;
import biz.golek.whattodofordinner.business.contract.presenters.SaveNewDinnerPreseneter;
import biz.golek.whattodofordinner.view.helpers.ViewState;

/**
 * Created by bg on 05.02.16.
 */
public class SaveNewDinnerPreseneterImpl implements SaveNewDinnerPreseneter {
    private ViewState viewState;

    public SaveNewDinnerPreseneterImpl(ViewState viewState) {
        this.viewState = viewState;
    }

    @Override
    public void ShowSaved() {
        Activity currentActivity = viewState.getCurrentActivity();
        Context context = currentActivity.getApplication().getApplicationContext();
        Resources res = context.getResources();
        Toast toast = Toast.makeText(context, res.getString(R.string.save_new_dinner_saved_message), Toast.LENGTH_SHORT);
        toast.show();
        currentActivity.finish();
    }
}
