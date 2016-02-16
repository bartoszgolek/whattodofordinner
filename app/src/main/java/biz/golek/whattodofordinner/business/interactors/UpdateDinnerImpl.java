package biz.golek.whattodofordinner.business.interactors;

import biz.golek.whattodofordinner.business.contract.dao.UpdateDinnerDao;
import biz.golek.whattodofordinner.business.contract.interactors.UpdateDinner;
import biz.golek.whattodofordinner.business.contract.presenters.UpdateDinnerPresenter;
import biz.golek.whattodofordinner.business.contract.request_data.UpdateDinnerRequestData;
import biz.golek.whattodofordinner.business.contract.entities.Dinner;

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
        Dinner entity = new Dinner();
        entity.setId(requestData.id);
        entity.setName(requestData.name);
        entity.setDuration(requestData.duration);
        entity.setSoup(requestData.soup);
        entity.setVegetarian(requestData.vegetarian);
        entity.setSeasons(requestData.seasons);

        updateDinnerDao.updateDinner(entity);

        updateDinnerPresenter.ShowSaved(entity);
    }
}
