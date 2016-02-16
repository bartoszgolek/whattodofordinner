package biz.golek.whattodofordinner;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;


/**
 * Created by bg on 06.02.16.
 */
public class MyDaoGenerator {
    public static void main(String[] args) throws Exception {
        Schema schema = new Schema(1, "biz.golek.whattodofordinner.database");

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
    }
}
