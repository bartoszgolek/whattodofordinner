package biz.golek.whattodofordinner.business.contract.dao;

import java.util.List;

import biz.golek.whattodofordinner.business.contract.entities.Dinner;

/**
 * Created by bgolek on 2016-02-24.
 */
public interface ShowMarkDinnerUsedDao {
    public List<Dinner> getAllDinners();
}
