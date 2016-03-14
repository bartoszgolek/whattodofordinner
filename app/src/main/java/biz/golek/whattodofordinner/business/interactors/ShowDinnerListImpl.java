package biz.golek.whattodofordinner.business.interactors;

import biz.golek.whattodofordinner.business.contract.interactors.ShowDinnerList;
import biz.golek.whattodofordinner.business.contract.presenters.ShowDinnerListPresenter;

/**
 * Created by Bartosz Gołek on 2016-02-08.
 */
public class ShowDinnerListImpl implements ShowDinnerList {
    private ShowDinnerListPresenter presenter;

    public ShowDinnerListImpl(ShowDinnerListPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void Run() {
        presenter.ShowView();
    }
}
