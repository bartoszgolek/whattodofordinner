package biz.golek.whattodofordinner.business.contract.dao;

import java.util.List;

import biz.golek.whattodofordinner.business.contract.entities.Dinner;
import biz.golek.whattodofordinner.business.contract.request_data.Duration;
import biz.golek.whattodofordinner.business.contract.request_data.Profile;

/**
 * Created by bg on 10.02.16.
 */
public interface GeneratePromptsDao {
    List<Dinner> GetPrompts(
            Duration maximum_duration,
            Profile vegetarian_profile,
            Profile soup_profile,
            Long[] excludes);

    void StoreDeny(Long[] excludes);
}
