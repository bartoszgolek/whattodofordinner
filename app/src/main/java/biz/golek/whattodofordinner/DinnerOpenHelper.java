package biz.golek.whattodofordinner;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import biz.golek.whattodofordinner.models.DaoMaster;
import kotlin.jvm.Throws;

/**
 * Created by bg on 07.02.16.
 */
public class DinnerOpenHelper extends DaoMaster.DevOpenHelper { //TODO:Remove DEV
    public DinnerOpenHelper(Context context) {
        super(context, "dinner-db", null);
    }
}
