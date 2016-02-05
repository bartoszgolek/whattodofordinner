package biz.golek.whattodofordinner.view.view_models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by bgolek on 2016-02-05.
 */
public class Dinner {
    public List<Map.Entry<Integer, String>> durations = new ArrayList<>();
    public Integer duration = 1;
    public String name = "Put Name";
    public boolean is_soup = true;
    public boolean is_vege = true;
}
