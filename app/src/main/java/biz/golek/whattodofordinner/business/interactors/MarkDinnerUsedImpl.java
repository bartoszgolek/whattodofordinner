package biz.golek.whattodofordinner.business.interactors;

import biz.golek.whattodofordinner.business.contract.dao.MarkDinnerUsedDao;
import biz.golek.whattodofordinner.business.contract.entities.Dinner;
import biz.golek.whattodofordinner.business.contract.interactors.MarkDinnerUsed;
import biz.golek.whattodofordinner.business.contract.presenters.MarkDinnerUsedPresenter;
import biz.golek.whattodofordinner.business.contract.request_data.MarkDinnerUsedRequestData;

/**
 * Created by Bartosz Gołek on 24.02.16.
 */
public class MarkDinnerUsedImpl implements MarkDinnerUsed {
    private MarkDinnerUsedDao dao;
    private MarkDinnerUsedPresenter presenter;

    public MarkDinnerUsedImpl(MarkDinnerUsedDao dao, MarkDinnerUsedPresenter presenter) {
        this.dao = dao;
        this.presenter = presenter;
    }

    @Override
    public void Run(MarkDinnerUsedRequestData requestData) {
        Dinner dinner = dao.GetDinner(requestData.dinnerId);
        dinner.setLastUsage(requestData.dinnerDate);
        dao.SaveDinner(dinner);

        presenter.Show();
    }
}
