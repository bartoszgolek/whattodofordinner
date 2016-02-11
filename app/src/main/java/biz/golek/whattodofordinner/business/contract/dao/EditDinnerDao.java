package biz.golek.whattodofordinner.business.contract.dao;

import biz.golek.whattodofordinner.models.Dinner;

/**
 * Created by bg on 10.02.16.
 */
public interface EditDinnerDao {
    Dinner GetDinner(Long id);
}
