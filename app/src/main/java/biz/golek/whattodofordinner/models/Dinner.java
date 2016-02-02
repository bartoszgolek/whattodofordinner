package biz.golek.whattodofordinner.models;

import com.orm.dsl.Table;

/**
 * Created by bg on 02.02.16.
 */
@Table
public class Dinner {
    private Long id;
    private String name;
    private Long durationType;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getDurationType() {
        return durationType;
    }
}
