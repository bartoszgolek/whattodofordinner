package biz.golek.whattodofordinner.database.migrations;

import android.database.sqlite.SQLiteDatabase;

import biz.golek.whattodofordinner.database.DinnerIngredientDao;
import biz.golek.whattodofordinner.database.DinnerStatDao;
import biz.golek.whattodofordinner.database.IngredientDao;
import biz.golek.whattodofordinner.utils.migrations.Migration;

/**
 * Created by Bartosz Gołek on 08.03.16.
 */
public class Migration1to2 implements Migration {
    @Override
    public void up(SQLiteDatabase db) {
        boolean ifNotExists = false;

        DinnerStatDao.createTable(db, ifNotExists);
        IngredientDao.createTable(db, ifNotExists);
        DinnerIngredientDao.createTable(db, ifNotExists);
    }
}
