package biz.golek.whattodofordinner.utils.migrations;

import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bartosz Gołek on 01.03.16.
 */
public class MigrationHelper {
    Class[] migrations;

    public MigrationHelper(Class[] migrations)
    {
        this.migrations = migrations;
    }

    public void Upgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        for(int i = oldVersion; i < newVersion; i++)
        {
            if(migrations.length < i)
                throw new RuntimeException("Missing migration to version " + (i + 1) + ".");

            Migration migration = null;
            try {
                Class migrationClass = migrations[i-1];
                migration = (Migration)migrationClass.newInstance();
            } catch (InstantiationException e) {
                throw new RuntimeException("Error: Cannot create migration to version " + (i + 1) + ".");
            } catch (IllegalAccessException e) {
                throw new RuntimeException("Error: Cannot create migration to version " + (i + 1) + ".");
            }

            migration.up(db);
        }
    }
}
