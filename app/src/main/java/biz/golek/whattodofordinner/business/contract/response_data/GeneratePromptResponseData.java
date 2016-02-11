package biz.golek.whattodofordinner.business.contract.response_data;

import java.util.List;

import biz.golek.whattodofordinner.business.contract.request_data.Duration;
import biz.golek.whattodofordinner.business.contract.request_data.Profile;

/**
 * Created by bg on 10.02.16.
 */
public class GeneratePromptResponseData {
    private List<DinnerListItem> prompts;
    private Long[] excludes;
    private Duration maximumDuration;
    private Profile soupProfile;
    private Profile vegetarianProfile;

    public GeneratePromptResponseData(
            List<DinnerListItem> prompts,
            Long[] excludes,
            Duration maximumDuration,
            Profile soupProfile,
            Profile vegetarianProfile) {

        this.prompts = prompts;
        this.excludes = excludes;
        this.maximumDuration = maximumDuration;
        this.soupProfile = soupProfile;
        this.vegetarianProfile = vegetarianProfile;
    }

    public List<DinnerListItem> getPrompts() {
        return prompts;
    }

    public Long[] getExcludes() {
        return excludes;
    }


    public Duration getMaximumDuration() {
        return maximumDuration;
    }

    public Profile getSoupProfile() {
        return soupProfile;
    }

    public Profile getVegetarianProfile() {
        return vegetarianProfile;
    }
}
