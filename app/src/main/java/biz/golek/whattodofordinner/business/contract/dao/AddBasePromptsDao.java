package biz.golek.whattodofordinner.business.contract.dao;

import biz.golek.whattodofordinner.business.contract.entities.Dinner;

/**
 * Created by Bartosz Gołek on 2016-02-16.
 */
public interface AddBasePromptsDao {
    Dinner[] Generate();
}
