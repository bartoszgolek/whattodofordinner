package biz.golek.whattodofordinner.business.contract.dao;

import biz.golek.whattodofordinner.models.Dinner;

/**
 * Created by bgolek on 2016-02-16.
 */
public interface AddBasePromptsDao {
    Dinner[] Generate();
}
