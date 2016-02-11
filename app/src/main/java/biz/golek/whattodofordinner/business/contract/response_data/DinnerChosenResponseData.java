package biz.golek.whattodofordinner.business.contract.response_data;

import java.io.Serializable;

/**
 * Created by bgolek on 2016-02-11.
 */
public class DinnerChosenResponseData implements Serializable {
    private final String name;

    public DinnerChosenResponseData(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
