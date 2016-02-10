package biz.golek.whattodofordinner.business.interactors;

import java.util.ArrayList;
import java.util.List;

import biz.golek.whattodofordinner.business.contract.dao.DinnerListDao;
import biz.golek.whattodofordinner.business.contract.interactors.DinnerList;
import biz.golek.whattodofordinner.business.contract.presenters.DinnerListPresenter;
import biz.golek.whattodofordinner.business.contract.response_data.DinnerListItem;
import biz.golek.whattodofordinner.models.Dinner;

/**
 * Created by bgolek on 2016-02-08.
 */
public class DinnerListImpl implements DinnerList {
    private DinnerListPresenter presenter;
    private DinnerListDao dao;

    public DinnerListImpl(
            DinnerListPresenter presenter,
            DinnerListDao dao) {
        this.presenter = presenter;
        this.dao = dao;
    }

    @Override
    public void Run() {
        List<DinnerListItem> result = new ArrayList<DinnerListItem>();

        List<Dinner> dinners = dao.getAllDinners();
        for (Dinner d: dinners) {
            DinnerListItem dinnerListItem = new DinnerListItem();
            dinnerListItem.id = d.getId();
            dinnerListItem.name = d.getName();
            result.add(dinnerListItem);
        };

        presenter.Show(result);
    }
}
