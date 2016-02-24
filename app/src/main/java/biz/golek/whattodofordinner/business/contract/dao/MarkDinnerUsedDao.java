package biz.golek.whattodofordinner.business.contract.dao;

import biz.golek.whattodofordinner.business.contract.entities.Dinner;

/**
 * Created by Bartosz Gołek on 24.02.16.
 */
public interface MarkDinnerUsedDao {
    Dinner GetDinner(Long dinnerId);
    void SaveDinner(Dinner dinner);
}
