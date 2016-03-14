package biz.golek.whattodofordinner.business.contract.presenters;

import java.util.List;

import biz.golek.whattodofordinner.business.contract.entities.Dinner;

/**
 * Created by bg on 14.03.16.
 */
public interface LoadDinnerListPresenter {
    void Show(List<Dinner> allDinners);
}
