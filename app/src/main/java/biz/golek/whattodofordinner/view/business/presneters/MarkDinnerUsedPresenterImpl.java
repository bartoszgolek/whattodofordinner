package biz.golek.whattodofordinner.view.business.presneters;

import android.app.Activity;
import android.content.res.Resources;

import biz.golek.whattodofordinner.R;
import biz.golek.whattodofordinner.business.contract.presenters.MarkDinnerUsedPresenter;
import biz.golek.whattodofordinner.view.presneters.CloseCurrentActivityPresenter;
import biz.golek.whattodofordinner.view.presneters.NotificationPresenter;

/**
 * Created by Bartosz Gołek on 24.02.16.
 */
public class MarkDinnerUsedPresenterImpl implements MarkDinnerUsedPresenter {
    private CloseCurrentActivityPresenter closeCurrentActivityPresenter;
    private NotificationPresenter notification;
    private Resources resources;

    public MarkDinnerUsedPresenterImpl(CloseCurrentActivityPresenter closeCurrentActivityPresenter, NotificationPresenter notification, Resources resources) {
        this.closeCurrentActivityPresenter = closeCurrentActivityPresenter;
        this.notification = notification;
        this.resources = resources;
    }

    @Override
    public void Show() {
        notification.show(resources.getString(R.string.dinner_used_message));

        closeCurrentActivityPresenter.closeActivity();
    }
}
