package biz.golek.whattodofordinner.view.business.presneters;

import biz.golek.whattodofordinner.business.contract.presenters.ShowMainPresenter;
import biz.golek.whattodofordinner.view.presneters.MainActivityPresenter;

/**
 * Created by bgolek on 2016-02-11.
 */
public class ShowMainPresenterImpl implements ShowMainPresenter {
    private MainActivityPresenter mainActivityPresenter;

    public ShowMainPresenterImpl(MainActivityPresenter mainActivityPresenter) {
        this.mainActivityPresenter = mainActivityPresenter;
    }

    @Override
    public void Run() {
        mainActivityPresenter.startActivity();
    }
}
