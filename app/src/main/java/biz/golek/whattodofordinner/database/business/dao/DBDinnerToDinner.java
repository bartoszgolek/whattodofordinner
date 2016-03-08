package biz.golek.whattodofordinner.database.business.dao;

import java.util.ArrayList;
import java.util.List;

import biz.golek.whattodofordinner.database.entities.Dinner;
import biz.golek.whattodofordinner.database.entities.Seasons;
import biz.golek.whattodofordinner.utils.FlagHelper;

/**
 * Created by bgolek on 2016-03-01.
 */
public class DBDinnerToDinner {
    public biz.golek.whattodofordinner.business.contract.entities.Dinner toBusiness(Dinner dinner) {
        return new biz.golek.whattodofordinner.business.contract.entities.Dinner(
            dinner.getId(),
            dinner.getName(),
            dinner.getDuration(),
            dinner.getSoup(),
            dinner.getVegetarian(),
            FlagHelper.flagIsSet(Seasons.spring, dinner.getSeasons()),
            FlagHelper.flagIsSet(Seasons.summer, dinner.getSeasons()),
            FlagHelper.flagIsSet(Seasons.autumn, dinner.getSeasons()),
            FlagHelper.flagIsSet(Seasons.winter, dinner.getSeasons()),
            dinner.getCreationDate(),
            dinner.getLastUsage(),
            dinner.getLastDrop()
        );
    }

    public List<biz.golek.whattodofordinner.business.contract.entities.Dinner> toBusiness(List<Dinner> dinners) {
        List<biz.golek.whattodofordinner.business.contract.entities.Dinner> result = new ArrayList<>();
        for (Dinner dinner: dinners)
            result.add(
                new biz.golek.whattodofordinner.business.contract.entities.Dinner(
                    dinner.getId(),
                    dinner.getName(),
                    dinner.getDuration(),
                    dinner.getSoup(),
                    dinner.getVegetarian(),
                    FlagHelper.flagIsSet(Seasons.spring, dinner.getSeasons()),
                    FlagHelper.flagIsSet(Seasons.summer, dinner.getSeasons()),
                    FlagHelper.flagIsSet(Seasons.autumn, dinner.getSeasons()),
                    FlagHelper.flagIsSet(Seasons.winter, dinner.getSeasons()),
                    dinner.getCreationDate(),
                    dinner.getLastUsage(),
                    dinner.getLastDrop()
                )
            );

        return result;
    }

    public Dinner toDatabase(biz.golek.whattodofordinner.business.contract.entities.Dinner dinner) {
        Dinner dbDinner = new Dinner();
        return toDatabase(dbDinner, dinner);
    }

    public Dinner toDatabase(Dinner dbDinner, biz.golek.whattodofordinner.business.contract.entities.Dinner dinner) {
        dbDinner.setId(dinner.getId());
        dbDinner.setName(dinner.getName());
        dbDinner.setDuration(dinner.getDuration());
        dbDinner.setSoup(dinner.getSoup());
        dbDinner.setVegetarian(dinner.getVegetarian());
        dbDinner.setSeasons(getSeasons(dinner));
        dbDinner.setCreationDate(dinner.getCreationDate());
        dbDinner.setLastUsage(dinner.getLastUsage());
        dbDinner.setLastDrop(dinner.getLastDrop());

        return dbDinner;
    }

    private int getSeasons(biz.golek.whattodofordinner.business.contract.entities.Dinner dinner) {
        int result = 0;

        if (dinner.getSpring())
            result = FlagHelper.setFlag(0, result);

        if (dinner.getSummer())
            result = FlagHelper.setFlag(1, result);

        if (dinner.getAutumn())
            result = FlagHelper.setFlag(2, result);

        if (dinner.getWinter())
            result = FlagHelper.setFlag(3, result);

        return result;
    }
}
