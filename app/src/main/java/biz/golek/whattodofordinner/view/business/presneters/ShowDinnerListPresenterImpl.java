package biz.golek.whattodofordinner.view.business.presneters;

import biz.golek.whattodofordinner.business.contract.presenters.ShowDinnerListPresenter;
import biz.golek.whattodofordinner.view.activities.DinnerListActivity;
import biz.golek.whattodofordinner.view.presneters.ActivityPresenter;
import biz.golek.whattodofordinner.view.view_models.DinnerListViewModel;

/**
 * Created by Bartosz Gołek on 2016-02-08.
 */
public class ShowDinnerListPresenterImpl implements ShowDinnerListPresenter {
    private ActivityPresenter activityPresenter;

    public ShowDinnerListPresenterImpl(ActivityPresenter activityPresenter) {

        this.activityPresenter = activityPresenter;
    }

    @Override
    public void ShowView() {
        DinnerListViewModel data = new DinnerListViewModel();
        activityPresenter.startActivity(DinnerListActivity.class, data);
    }
}
