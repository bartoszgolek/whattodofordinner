package biz.golek.whattodofordinner.business.interactors;

import biz.golek.whattodofordinner.business.contract.dao.LoadDinnerListDao;
import biz.golek.whattodofordinner.business.contract.interactors.LoadDinnerList;
import biz.golek.whattodofordinner.business.contract.presenters.LoadDinnerListPresenter;

/**
 * Created by bg on 14.03.16.
 */
public class LoadDinnerListImpl implements LoadDinnerList {
    private LoadDinnerListPresenter presenter;
    private LoadDinnerListDao dao;

    public LoadDinnerListImpl(LoadDinnerListPresenter presenter, LoadDinnerListDao dao) {
        this.presenter = presenter;
        this.dao = dao;
    }

    @Override
    public void run() {
        new Thread(new Runnable() {
            public void run() {
                presenter.Show(dao.getAllDinners());
            }
        }).start();
    }
}
