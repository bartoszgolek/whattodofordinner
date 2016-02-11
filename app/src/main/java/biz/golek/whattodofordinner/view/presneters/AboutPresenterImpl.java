package biz.golek.whattodofordinner.view.presneters;

import biz.golek.whattodofordinner.business.contract.presenters.AboutPresenter;
import biz.golek.whattodofordinner.view.activities.AboutActivity;

/**
 * Created by bg on 12.02.16.
 */
public class AboutPresenterImpl implements AboutPresenter {
    private ActivityPresenter activity_presenter;

    public AboutPresenterImpl(ActivityPresenter activity_presenter) {
        this.activity_presenter = activity_presenter;
    }

    @Override
    public void Show() {
        activity_presenter.startActivity(AboutActivity.class);
    }
}
