package biz.golek.whattodofordinner.database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

import biz.golek.whattodofordinner.database.entities.Dinner;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "DINNER".
*/
public class DinnerDao extends AbstractDao<Dinner, Long> {

    public static final String TABLENAME = "DINNER";

    /**
     * Properties of entity Dinner.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Name = new Property(1, String.class, "name", false, "NAME");
        public final static Property Duration = new Property(2, int.class, "duration", false, "DURATION");
        public final static Property Seasons = new Property(3, int.class, "seasons", false, "SEASONS");
        public final static Property Soup = new Property(4, boolean.class, "soup", false, "SOUP");
        public final static Property Vegetarian = new Property(5, boolean.class, "vegetarian", false, "VEGETARIAN");
        public final static Property LastUsage = new Property(6, java.util.Date.class, "lastUsage", false, "LAST_USAGE");
        public final static Property LastDrop = new Property(7, java.util.Date.class, "lastDrop", false, "LAST_DROP");
        public final static Property CreationDate = new Property(8, java.util.Date.class, "creationDate", false, "CREATION_DATE");
    };

    private DaoSession daoSession;


    public DinnerDao(DaoConfig config) {
        super(config);
    }
    
    public DinnerDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"DINNER\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"NAME\" TEXT NOT NULL ," + // 1: name
                "\"DURATION\" INTEGER NOT NULL ," + // 2: duration
                "\"SEASONS\" INTEGER NOT NULL ," + // 3: seasons
                "\"SOUP\" INTEGER NOT NULL ," + // 4: soup
                "\"VEGETARIAN\" INTEGER NOT NULL ," + // 5: vegetarian
                "\"LAST_USAGE\" INTEGER," + // 6: lastUsage
                "\"LAST_DROP\" INTEGER," + // 7: lastDrop
                "\"CREATION_DATE\" INTEGER NOT NULL );"); // 8: creationDate
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"DINNER\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, Dinner entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindString(2, entity.getName());
        stmt.bindLong(3, entity.getDuration());
        stmt.bindLong(4, entity.getSeasons());
        stmt.bindLong(5, entity.getSoup() ? 1L: 0L);
        stmt.bindLong(6, entity.getVegetarian() ? 1L: 0L);
 
        java.util.Date lastUsage = entity.getLastUsage();
        if (lastUsage != null) {
            stmt.bindLong(7, lastUsage.getTime());
        }
 
        java.util.Date lastDrop = entity.getLastDrop();
        if (lastDrop != null) {
            stmt.bindLong(8, lastDrop.getTime());
        }
        stmt.bindLong(9, entity.getCreationDate().getTime());
    }

    @Override
    protected void attachEntity(Dinner entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public Dinner readEntity(Cursor cursor, int offset) {
        Dinner entity = new Dinner( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.getString(offset + 1), // name
            cursor.getInt(offset + 2), // duration
            cursor.getInt(offset + 3), // seasons
            cursor.getShort(offset + 4) != 0, // soup
            cursor.getShort(offset + 5) != 0, // vegetarian
            cursor.isNull(offset + 6) ? null : new java.util.Date(cursor.getLong(offset + 6)), // lastUsage
            cursor.isNull(offset + 7) ? null : new java.util.Date(cursor.getLong(offset + 7)), // lastDrop
            new java.util.Date(cursor.getLong(offset + 8)) // creationDate
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, Dinner entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setName(cursor.getString(offset + 1));
        entity.setDuration(cursor.getInt(offset + 2));
        entity.setSeasons(cursor.getInt(offset + 3));
        entity.setSoup(cursor.getShort(offset + 4) != 0);
        entity.setVegetarian(cursor.getShort(offset + 5) != 0);
        entity.setLastUsage(cursor.isNull(offset + 6) ? null : new java.util.Date(cursor.getLong(offset + 6)));
        entity.setLastDrop(cursor.isNull(offset + 7) ? null : new java.util.Date(cursor.getLong(offset + 7)));
        entity.setCreationDate(new java.util.Date(cursor.getLong(offset + 8)));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(Dinner entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(Dinner entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
}
