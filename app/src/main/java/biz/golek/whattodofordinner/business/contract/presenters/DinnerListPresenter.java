package biz.golek.whattodofordinner.business.contract.presenters;

import java.util.List;

import biz.golek.whattodofordinner.business.contract.response_data.DinnerListItem;

/**
 * Created by bgolek on 2016-02-08.
 */
public interface DinnerListPresenter {
    void Show(List<DinnerListItem> dinners);
}
