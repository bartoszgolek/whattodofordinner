package biz.golek.whattodofordinner.view.business.presneters;

import biz.golek.whattodofordinner.business.contract.presenters.DinnerAcceptedPresenter;
import biz.golek.whattodofordinner.view.presneters.MainActivityPresenter;

/**
 * Created by bg on 11.02.16.
 */
public class DinnerAcceptedPresenterImpl implements DinnerAcceptedPresenter {
    private MainActivityPresenter presenter;

    public DinnerAcceptedPresenterImpl(MainActivityPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void ShowAccepted() {
        presenter.startActivity();
    }
}
