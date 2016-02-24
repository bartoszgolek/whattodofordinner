package biz.golek.whattodofordinner.business.contract.response_data;

import java.io.Serializable;

/**
 * Created by Bartosz Gołek on 2016-02-08.
 */
public class DinnerListItem implements Serializable {
    public Long id;
    public String name;

    @Override
    public String toString() {
        return name;
    }
}
