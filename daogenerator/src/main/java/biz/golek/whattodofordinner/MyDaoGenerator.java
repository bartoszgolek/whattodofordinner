package biz.golek.whattodofordinner;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Property;
import de.greenrobot.daogenerator.Schema;
import de.greenrobot.daogenerator.ToMany;


/**
 * Created by bg on 06.02.16.
 */
public class MyDaoGenerator {
    public static void main(String[] args) throws Exception {
        Schema schema = new Schema(2, "biz.golek.whattodofordinner.database");

        addDinner(schema);

        new DaoGenerator().generateAll(schema, "../app/src/main/java");
    }

    private static void addDinner(Schema schema) {
        Entity dinner = schema.addEntity("Dinner");
        dinner.setJavaPackage("biz.golek.whattodofordinner.business.contract.entities");
        dinner.setJavaPackageDao("biz.golek.whattodofordinner.database");
        dinner.addIdProperty();
        dinner.addStringProperty("name").notNull();
        dinner.addIntProperty("duration").notNull();
        dinner.addIntProperty("seasons").notNull();
        dinner.addBooleanProperty("soup").notNull();
        dinner.addBooleanProperty("vegetarian").notNull();
        dinner.addDateProperty("lastUsage");
        dinner.addDateProperty("lastDrop");
        dinner.addDateProperty("creationDate").notNull();

        Entity dinnerStat = schema.addEntity("DinnerStat");
        dinnerStat.setJavaPackage("biz.golek.whattodofordinner.business.contract.entities");
        dinnerStat.setJavaPackageDao("biz.golek.whattodofordinner.database");
        dinnerStat.addIdProperty();
        Property statType = dinnerStat.addIntProperty("type").notNull().getProperty();
        Property statDate = dinnerStat.addDateProperty("date").notNull().getProperty();

        Property statDinnerId = dinnerStat.addLongProperty("dinnerId").notNull().getProperty();
        ToMany dinnerToStats = dinner.addToMany(dinnerStat, statDinnerId);
        dinnerToStats.setName("DinnerStats");
        dinnerToStats.orderAsc(statDate, statType);

        Entity ingredient = schema.addEntity("Ingredient");
        ingredient.setJavaPackage("biz.golek.whattodofordinner.business.contract.entities");
        ingredient.setJavaPackageDao("biz.golek.whattodofordinner.database");
        ingredient.addIdProperty();
        ingredient.addShortProperty("Name");

        Entity dinnerIngredient = schema.addEntity("DinnerIngredient");
        dinnerIngredient.setJavaPackage("biz.golek.whattodofordinner.business.contract.entities");
        dinnerIngredient.setJavaPackageDao("biz.golek.whattodofordinner.database");
        dinnerIngredient.addIdProperty();
        Property dinnerIngredientDinnerId = dinnerIngredient.addLongProperty("dinnerId")
            .notNull().getProperty();
        Property dinnerIngredientIngredientId = dinnerIngredient.addLongProperty("ingredientId")
                .notNull().getProperty();
        dinnerToStats.setName("DinnerIngredientDinner");

        ToMany dinnerIngredientToDinners =
            dinner.addToMany(dinnerIngredient, dinnerIngredientDinnerId);
        dinnerIngredientToDinners.setName("DinnerIngredientToDinners");
        ToMany dinnerIngredientToIngredients =
            ingredient.addToMany(dinnerIngredient, dinnerIngredientIngredientId);
        dinnerIngredientToIngredients.setName("DinnerIngredientToIngredients");
    }
}
