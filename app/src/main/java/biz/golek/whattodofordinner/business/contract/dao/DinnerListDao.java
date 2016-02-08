package biz.golek.whattodofordinner.business.contract.dao;

import java.util.List;

import biz.golek.whattodofordinner.models.Dinner;

/**
 * Created by bg on 08.02.16.
 */
public interface DinnerListDao {
    List<Dinner> getAllDinners();
}
