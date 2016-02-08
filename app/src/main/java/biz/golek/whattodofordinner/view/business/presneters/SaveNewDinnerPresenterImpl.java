package biz.golek.whattodofordinner.view.business.presneters;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;

import biz.golek.whattodofordinner.R;
import biz.golek.whattodofordinner.business.contract.presenters.SaveNewDinnerPresenter;
import biz.golek.whattodofordinner.view.helpers.ViewState;
import biz.golek.whattodofordinner.view.presneters.NotificationPresenter;

/**
 * Created by bg on 05.02.16.
 */
public class SaveNewDinnerPresenterImpl implements SaveNewDinnerPresenter {
    private ViewState viewState;
    private NotificationPresenter notification;
    private EventBus eventBus;

    public SaveNewDinnerPresenterImpl(
            ViewState viewState,
            NotificationPresenter notification,
            EventBus eventBus) {
        this.viewState = viewState;
        this.notification = notification;
        this.eventBus = eventBus;
    }

    @Override
    public void ShowSaved() {
        Activity currentActivity = viewState.getCurrentActivity();
        Resources res = currentActivity.getApplication().getApplicationContext().getResources();
        notification.show(res.getString(R.string.save_new_dinner_saved_message));

        //eventBus.post(dinnerListItem)

        currentActivity.finish();
    }
}
