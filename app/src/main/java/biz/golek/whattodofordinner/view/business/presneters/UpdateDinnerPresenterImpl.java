package biz.golek.whattodofordinner.view.business.presneters;

import android.app.Activity;
import android.content.res.Resources;

import org.greenrobot.eventbus.EventBus;

import biz.golek.whattodofordinner.R;
import biz.golek.whattodofordinner.business.contract.presenters.UpdateDinnerPresenter;
import biz.golek.whattodofordinner.business.contract.entities.Dinner;
import biz.golek.whattodofordinner.view.presneters.CloseCurrentActivityPresenter;
import biz.golek.whattodofordinner.view.presneters.NotificationPresenter;

/**
 * Created by Bartosz Gołek on 2016-02-10.
 */
public class UpdateDinnerPresenterImpl implements UpdateDinnerPresenter {
    private NotificationPresenter notification;
    private CloseCurrentActivityPresenter closeCurrentActivityPresenter;
    private Resources resources;

    public UpdateDinnerPresenterImpl(NotificationPresenter notification, CloseCurrentActivityPresenter closeCurrentActivityPresenter, Resources resources) {
        this.notification = notification;
        this.closeCurrentActivityPresenter = closeCurrentActivityPresenter;
        this.resources = resources;
    }

    @Override
    public void ShowSaved(Dinner dinner) {
        notification.show(resources.getString(R.string.update_dinner_saved_message));
        closeCurrentActivityPresenter.closeActivity();
    }
}
