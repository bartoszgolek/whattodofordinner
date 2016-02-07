package biz.golek.whattodofordinner;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import biz.golek.whattodofordinner.models.DaoMaster;

/**
 * Created by bg on 07.02.16.
 */
public class DinnerOpenHelper extends DaoMaster.OpenHelper {
    public DinnerOpenHelper(Context context) {
        super(context, "dinner-db", null);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
