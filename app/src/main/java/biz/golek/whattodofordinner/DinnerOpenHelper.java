package biz.golek.whattodofordinner;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import biz.golek.whattodofordinner.database.DaoMaster;
import biz.golek.whattodofordinner.utils.migrations.MigrationHelper;

/**
 * Created by bg on 07.02.16.
 */
public class DinnerOpenHelper extends DaoMaster.OpenHelper {
    private MigrationHelper migrationHelper;

    public DinnerOpenHelper(Context context, MigrationHelper migrationHelper) {
        super(context, "dinner-db", null);
        this.migrationHelper = migrationHelper;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        migrationHelper.Upgrade(db, oldVersion, newVersion);
    }
}
