package biz.golek.whattodofordinner.view.view_models;

import java.io.Serializable;
import java.util.List;

import biz.golek.whattodofordinner.business.contract.request_data.Duration;
import biz.golek.whattodofordinner.business.contract.request_data.Profile;
import biz.golek.whattodofordinner.business.contract.response_data.DinnerListItem;

/**
 * Created by bg on 10.02.16.
 */
public class PromptsActivityViewModel implements Serializable {
    private List<DinnerListItem> prompts;
    private Long[] excludes;
    private Profile soupProfile;
    private Profile vegetarianProfile;
    private Duration maximumDuration;

    public List<DinnerListItem> getPrompts() {
        return prompts;
    }

    public void setPrompts(List<DinnerListItem> prompts) {
        this.prompts = prompts;
    }

    public Long[] getExcludes() {
        return excludes;
    }

    public void setExcludes(Long[] excludes) {
        this.excludes = excludes;
    }

    public Profile getSoupProfile() {
        return soupProfile;
    }

    public Profile getVegetarianProfile() {
        return vegetarianProfile;
    }

    public Duration getMaximumDuration() {
        return maximumDuration;
    }

    public void setSoupProfile(Profile soupProfile) {
        this.soupProfile = soupProfile;
    }

    public void setVegetarianProfile(Profile vegetarianProfile) {
        this.vegetarianProfile = vegetarianProfile;
    }

    public void setMaximumDuration(Duration maximumDuration) {
        this.maximumDuration = maximumDuration;
    }
}
