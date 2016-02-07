package biz.golek.whattodofordinner;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
//import de.greenrobot.daogenerator.Property;
import de.greenrobot.daogenerator.Schema;
//import de.greenrobot.daogenerator.ToMany;


/**
 * Created by bg on 06.02.16.
 */
public class MyDaoGenerator {
    public static void main(String[] args) throws Exception {
        Schema schema = new Schema(1000, "biz.golek.whattodofordinner.models");

        addDinner(schema);
        //addCustomerOrder(schema);

        new DaoGenerator().generateAll(schema, "../app/src/main/java");
    }

    private static void addDinner(Schema schema) {
        Entity dinner = schema.addEntity("Dinner");
        dinner.addIdProperty();
        dinner.addStringProperty("name").notNull();
        dinner.addIntProperty("duration");
        dinner.addBooleanProperty("soup");
        dinner.addBooleanProperty("vegetarian");
    }

//    private static void addCustomerOrder(Schema schema) {
//        Entity customer = schema.addEntity("Customer");
//        customer.addIdProperty();
//        customer.addStringProperty("name").notNull();
//
//        Entity order = schema.addEntity("Order");
//        order.setTableName("ORDERS"); // "ORDER" is a reserved keyword
//        order.addIdProperty();
//        Property orderDate = order.addDateProperty("date").getProperty();
//        Property customerId = order.addLongProperty("customerId").notNull().getProperty();
//        order.addToOne(customer, customerId);
//
//        ToMany customerToOrders = customer.addToMany(order, customerId);
//        customerToOrders.setName("orders");
//        customerToOrders.orderAsc(orderDate);
//    }
}
