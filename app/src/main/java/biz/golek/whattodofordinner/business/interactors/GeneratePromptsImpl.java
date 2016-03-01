package biz.golek.whattodofordinner.business.interactors;

import java.util.ArrayList;
import java.util.List;

import biz.golek.whattodofordinner.business.contract.dao.GeneratePromptsDao;
import biz.golek.whattodofordinner.business.contract.entities.Dinner;
import biz.golek.whattodofordinner.business.contract.interactors.GeneratePrompts;
import biz.golek.whattodofordinner.business.contract.presenters.GeneratePromptsPresenter;
import biz.golek.whattodofordinner.business.contract.request_data.GeneratePromptsRequestData;
import biz.golek.whattodofordinner.business.contract.response_data.DinnerListItem;
import biz.golek.whattodofordinner.business.contract.response_data.GeneratePromptResponseData;

/**
 * Created by bg on 10.02.16.
 */
public class GeneratePromptsImpl implements GeneratePrompts {
    private final GeneratePromptsDao dao;
    private final GeneratePromptsPresenter presenter;

    public GeneratePromptsImpl(
            GeneratePromptsDao dao,
            GeneratePromptsPresenter presenter) {
        this.dao = dao;
        this.presenter = presenter;
    }

    @Override
    public void Run(GeneratePromptsRequestData requestData) {
        dao.StoreDeny(requestData.excludes);
        List<Dinner> prompts = dao.GetPrompts(
                requestData.maximum_duration,
                requestData.vegetarian_profile,
                requestData.soup_profile,
                requestData.excludes);

        List<DinnerListItem> result = new ArrayList<>();

        if (prompts.size() > 0) {
            for (Dinner d : prompts) {
                DinnerListItem dinnerListItem = new DinnerListItem();
                dinnerListItem.id = d.getId();
                dinnerListItem.name = d.getName();
                result.add(dinnerListItem);
            }

            presenter.Show(
                    new GeneratePromptResponseData(
                            result,
                            requestData.excludes,
                            requestData.maximum_duration,
                            requestData.soup_profile,
                            requestData.vegetarian_profile
                    )
            );
        }
        else
        {
            presenter.ShowEmptyResult();
        }
    }
}
