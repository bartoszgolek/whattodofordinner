package biz.golek.whattodofordinner.view.business.presneters;

import biz.golek.whattodofordinner.business.contract.presenters.ShowMarkDinnerUsedPresenter;
import biz.golek.whattodofordinner.view.activities.MarkDinnerUsedActivity;
import biz.golek.whattodofordinner.view.presneters.ActivityPresenter;
import biz.golek.whattodofordinner.view.view_models.MarkDinnerUsedViewModel;

/**
 * Created by Bartosz Gołek on 23.02.16.
 */
public class ShowMarkDinnerUsedPresenterImpl implements ShowMarkDinnerUsedPresenter {
    private ActivityPresenter activityPresenter;

    public ShowMarkDinnerUsedPresenterImpl(ActivityPresenter activityPresenter) {
        this.activityPresenter = activityPresenter;
    }

    @Override
    public void Show(MarkDinnerUsedViewModel vm) {
        activityPresenter.startActivity(MarkDinnerUsedActivity.class, vm);
    }
}
