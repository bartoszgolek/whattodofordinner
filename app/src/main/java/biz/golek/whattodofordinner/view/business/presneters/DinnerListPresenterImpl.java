package biz.golek.whattodofordinner.view.business.presneters;

import java.util.List;

import biz.golek.whattodofordinner.business.contract.presenters.DinnerListPresenter;
import biz.golek.whattodofordinner.business.contract.response_data.DinnerListItem;
import biz.golek.whattodofordinner.view.helpers.ViewState;

/**
 * Created by bgolek on 2016-02-08.
 */
public class DinnerListPresenterImpl implements DinnerListPresenter {
    private ViewState viewState;

    public DinnerListPresenterImpl(ViewState viewState) {

        this.viewState = viewState;
    }

    @Override
    public void Show(List<DinnerListItem> dinners) {

    }
}
