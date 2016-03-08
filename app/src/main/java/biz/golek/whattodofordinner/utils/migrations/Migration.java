package biz.golek.whattodofordinner.utils.migrations;

import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Bartosz Gołek on 01.03.16.
 */
public interface Migration {
    void up(SQLiteDatabase db);
}
