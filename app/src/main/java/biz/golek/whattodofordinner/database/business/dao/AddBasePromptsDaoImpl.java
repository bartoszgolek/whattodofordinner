package biz.golek.whattodofordinner.database.business.dao;

import java.util.Date;

import javax.inject.Provider;

import biz.golek.whattodofordinner.business.contract.dao.AddBasePromptsDao;
import biz.golek.whattodofordinner.business.contract.entities.Dinner;
import biz.golek.whattodofordinner.database.DinnerDao;
import biz.golek.whattodofordinner.view.helpers.FlagHelper;

/**
 * Created by Bartosz Gołek on 2016-02-16.
 */
public class AddBasePromptsDaoImpl implements AddBasePromptsDao {
    private Provider<DinnerDao> daoProvider;

    public AddBasePromptsDaoImpl(Provider<DinnerDao> daoProvider) {
        this.daoProvider = daoProvider;
    }

    @Override
    public Dinner[] Generate() {
        DinnerDao dao = daoProvider.get();

        Dinner[] dinners = new Dinner[] {
            insertDinner(dao, "Rosół", 0, true, false, false, false, false, false),
            insertDinner(dao, "Grzybowa", 0, true, false, false, false, true, false),
            insertDinner(dao, "Pomidorowa", 0, true, true, false, false, false, false),
            insertDinner(dao, "Grochowa", 0, true, false, false, false, false, false),
            insertDinner(dao, "Jarzynowa", 1, true, true, true, false, false, false),
            insertDinner(dao, "Ogórkowa", 1, true, true, true, false, false, false),
            insertDinner(dao, "Kapuśniak", 1, true, false, false, false, false, false),
            insertDinner(dao, "Krupnik", 1, true, false, false, false, false, false),
            insertDinner(dao, "Barszcz", 1, true, false, false, false, false, false),
            insertDinner(dao, "Placki ziemniaczane", 1, false, true, false, false, true, false),
            insertDinner(dao, "Schabowy z ziemniakami", 1, false, false, false, false, false, false),
            insertDinner(dao, "Rumsztyk", 1, false, false, false, false, false, false),
            insertDinner(dao, "Kotlety mielone", 1, false, false, false, false, false, false),
            insertDinner(dao, "Burgery", 2, false, true, false, false, false, false),
            insertDinner(dao, "Wątróbka smażona", 0, false, false, false, false, false, false),
            insertDinner(dao, "Wątróbka drobiowa duszona w sosie pomidorowym", 1, false, false, false, false, false, false),
            insertDinner(dao, "Gulasz", 1, false, false, false, false, false, false),
            insertDinner(dao, "Leczo", 1, false, false, false, false, false, false),
            insertDinner(dao, "Filet rybny smażony", 1, false, false, false, false, false, false),
            insertDinner(dao, "Paluszki rybne", 0, false, false, false, false, false, false),
            insertDinner(dao, "Łosoś pieczony ze szpinakiem", 0, false, false, false, false, false, false),
            insertDinner(dao, "Śledź w śmietanie", 0, false, false, false, false, false, false),
            insertDinner(dao, "Pyra z Gzikiem", 0, false, false, false, false, false, false),
            insertDinner(dao, "Gotwane warzywa w sosie serowym", 0, false, true, false, false, false, false),
            insertDinner(dao, "Fasolka po bretońsku", 0, false, false, false, false, false, false),
            insertDinner(dao, "Naleśniki z serem", 0, false, false, false, false, false, false),
            insertDinner(dao, "Naleśniki z kurczakiem i pieczarkami", 0, false, false, false, false, false, false),
            insertDinner(dao, "Tortilla z kurczakiem i pieczarkami", 0, false, false, false, false, false, false),
            insertDinner(dao, "Risotto", 1, false, false, false, false, false, false),
            insertDinner(dao, "Penne ze szpinakiem", 1, false, true, false, false, false, false),
            insertDinner(dao, "Spaghetti Bolognese", 1, false, false, false, false, false, false),
            insertDinner(dao, "Lasagne", 1, false, false, false, false, false, false),
            insertDinner(dao, "Kluski śląskie w sosie pieczarkowym", 1, false, false, false, false, false, false),
            insertDinner(dao, "Kurczak grillowany na sałącie z pomidorkami koktajlowymi i vinegare", 1, false, false, false, false, false, false),
            insertDinner(dao, "Kurczak pieczony w majonezie", 1, false, false, false, false, false, false),
            insertDinner(dao, "Penne carbonara", 1, false, false, false, false, false, false),
            insertDinner(dao, "Pierogi \"ruskie\"", 1, false, true, false, false, false, false),
            insertDinner(dao, "Pierogi z kapustą i grzybami", 1, false, true, false, false, false, false),
            insertDinner(dao, "Pierogi z mięsem", 1, false, false, false, false, false, false),
            insertDinner(dao, "Pyzy z mięsem", 1, false, false, false, false, false, false),
            insertDinner(dao, "Kopytka z kapustą", 1, false, false, false, false, false, false)
        };
        return dinners;
    }

    private Dinner insertDinner(DinnerDao dao, String name, int duration, boolean soup, boolean vegetarian, boolean spring, boolean summer, boolean autumn, boolean winter) {
        biz.golek.whattodofordinner.database.entities.Dinner dinner =
            new biz.golek.whattodofordinner.database.entities.Dinner();
        dinner.setName(name);
        dinner.setDuration(duration);
        dinner.setSoup(soup);
        dinner.setVegetarian(vegetarian);
        dinner.setSeasons(getSeasonsValue(spring, summer, autumn, winter));

        dinner.setCreationDate(new Date());

        dao.insert(dinner);

        return new Dinner(dinner.getId(), name, duration, soup, vegetarian, spring, summer, autumn, winter, dinner.getCreationDate());
    }

    private int getSeasonsValue(boolean spring, boolean summer, boolean autumn, boolean winter) {
        int result = 0;
        if (spring)
            result = FlagHelper.setFlag(0, result);

        if (summer)
            result = FlagHelper.setFlag(1, result);

        if (autumn)
            result = FlagHelper.setFlag(2, result);

        if (winter)
            result = FlagHelper.setFlag(3, result);

        return result;
    }
}
