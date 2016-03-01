package biz.golek.whattodofordinner.business.interactors;

import biz.golek.whattodofordinner.business.contract.dao.UpdateDinnerDao;
import biz.golek.whattodofordinner.business.contract.entities.Dinner;
import biz.golek.whattodofordinner.business.contract.interactors.UpdateDinner;
import biz.golek.whattodofordinner.business.contract.presenters.UpdateDinnerPresenter;
import biz.golek.whattodofordinner.business.contract.request_data.UpdateDinnerRequestData;

/**
 * Created by Bartosz Gołek on 2016-02-10.
 */
public class UpdateDinnerImpl implements UpdateDinner {
    private UpdateDinnerPresenter updateDinnerPresenter;
    private UpdateDinnerDao updateDinnerDao;

    public UpdateDinnerImpl(UpdateDinnerPresenter updateDinnerPresenter, UpdateDinnerDao updateDinnerDao) {
        this.updateDinnerPresenter = updateDinnerPresenter;
        this.updateDinnerDao = updateDinnerDao;
    }

    @Override
    public void Run(UpdateDinnerRequestData requestData) {
        Dinner dinner = new Dinner(
            requestData.id,
            requestData.name,
            requestData.duration,
            requestData.soup,
            requestData.vegetarian,
            requestData.spring,
            requestData.summer,
            requestData.autumn,
            requestData.winter
        );

        updateDinnerDao.updateDinner(dinner);

        updateDinnerPresenter.ShowSaved(dinner);
    }
}
