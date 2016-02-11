package biz.golek.whattodofordinner.view.business.presneters;

import biz.golek.whattodofordinner.business.contract.presenters.EditDinnerPresenter;
import biz.golek.whattodofordinner.models.Dinner;
import biz.golek.whattodofordinner.view.activities.EditDinnerActivity;
import biz.golek.whattodofordinner.view.presneters.ActivityPresenter;
import biz.golek.whattodofordinner.view.view_models.DinnerFormViewModel;
import biz.golek.whattodofordinner.view.view_models.EditDinnerFormViewModel;

/**
 * Created by bgolek on 2016-02-10.
 */
public class EditDinnerPresenterImpl implements EditDinnerPresenter {
    private ActivityPresenter starter;

    public EditDinnerPresenterImpl(ActivityPresenter starter) {
        this.starter = starter;
    }

    @Override
    public void Show(Dinner dinner) {
        EditDinnerFormViewModel data = new EditDinnerFormViewModel();

        data.id = dinner.getId();
        data.setName(dinner.getName());
        data.setDuration(dinner.getDuration());
        data.setSoup(dinner.getSoup());
        data.setVegetarian(dinner.getVegetarian());
        data.setSeasons(dinner.getSeasons());

        starter.startActivity(EditDinnerActivity.class, data);
    }
}
