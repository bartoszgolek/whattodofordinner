package biz.golek.whattodofordinner.business.interactors;

import biz.golek.whattodofordinner.business.contract.dao.DinnerChosenDao;
import biz.golek.whattodofordinner.business.contract.interactors.DinnerChosen;
import biz.golek.whattodofordinner.business.contract.presenters.DinnerChosenPresenter;
import biz.golek.whattodofordinner.business.contract.response_data.DinnerChosenResponseData;

/**
 * Created by bg on 11.02.16.
 */
public class DinnerChosenImpl implements DinnerChosen {
    private DinnerChosenDao dao;
    private DinnerChosenPresenter presenter;

    public DinnerChosenImpl(DinnerChosenDao dao, DinnerChosenPresenter presenter) {
        this.dao = dao;
        this.presenter = presenter;
    }

    @Override
    public void Run(Long id, String name) {
        dao.SetDinnerAccepted(id);
        presenter.Show(new DinnerChosenResponseData(name));
    }
}
