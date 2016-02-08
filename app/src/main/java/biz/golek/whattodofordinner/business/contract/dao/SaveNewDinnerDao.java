package biz.golek.whattodofordinner.business.contract.dao;

import biz.golek.whattodofordinner.models.Dinner;

/**
 * Created by bg on 08.02.16.
 */
public interface SaveNewDinnerDao {
    void saveDinner(Dinner entity);
}
