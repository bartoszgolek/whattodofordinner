package biz.golek.whattodofordinner.view.view_models;

import java.io.Serializable;
import java.util.List;

import biz.golek.whattodofordinner.business.contract.response_data.DinnerListItem;

/**
 * Created by bgolek on 2016-02-08.
 */
public class DinnerListViewModel implements Serializable {
    public List<DinnerListItem> dinners;
}
