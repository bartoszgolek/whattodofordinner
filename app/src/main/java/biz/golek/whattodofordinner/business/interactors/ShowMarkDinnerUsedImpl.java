package biz.golek.whattodofordinner.business.interactors;

import biz.golek.whattodofordinner.business.contract.dao.ShowMarkDinnerUsedDao;
import biz.golek.whattodofordinner.business.contract.entities.Dinner;
import biz.golek.whattodofordinner.business.contract.interactors.ShowMarkDinnerUsed;
import biz.golek.whattodofordinner.business.contract.presenters.ShowMarkDinnerUsedPresenter;
import biz.golek.whattodofordinner.business.contract.response_data.DinnerListItem;
import biz.golek.whattodofordinner.view.view_models.MarkDinnerUsedViewModel;

/**
 * Created by Bartosz Gołek on 23.02.16.
 */
public class ShowMarkDinnerUsedImpl implements ShowMarkDinnerUsed {
    private ShowMarkDinnerUsedPresenter presenter;
    private ShowMarkDinnerUsedDao dao;

    public ShowMarkDinnerUsedImpl(ShowMarkDinnerUsedPresenter presenter, ShowMarkDinnerUsedDao dao) {
        this.presenter = presenter;
        this.dao = dao;
    }

    @Override
    public void Run() {
        MarkDinnerUsedViewModel vm = new MarkDinnerUsedViewModel();

        for (Dinner d: dao.getAllDinners()){
            DinnerListItem listItem = new DinnerListItem();
            listItem.id = d.getId();
            listItem.name = d.getName();
            vm.dinners.add(listItem);
        }
        presenter.Show(vm);
    }
}
