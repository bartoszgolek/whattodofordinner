package biz.golek.whattodofordinner.database.entities;

import java.util.List;
import biz.golek.whattodofordinner.database.DaoSession;
import de.greenrobot.dao.DaoException;

import biz.golek.whattodofordinner.database.DinnerDao;
import biz.golek.whattodofordinner.database.DinnerIngredientDao;
import biz.golek.whattodofordinner.database.DinnerStatDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table "DINNER".
 */
public class Dinner {

    private Long id;
    /** Not-null value. */
    private String name;
    private int duration;
    private int seasons;
    private boolean soup;
    private boolean vegetarian;
    private java.util.Date lastUsage;
    private java.util.Date lastDrop;
    /** Not-null value. */
    private java.util.Date creationDate;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient DinnerDao myDao;

    private List<DinnerStat> DinnerIngredientDinner;
    private List<DinnerIngredient> DinnerIngredientToDinners;

    public Dinner() {
    }

    public Dinner(Long id) {
        this.id = id;
    }

    public Dinner(Long id, String name, int duration, int seasons, boolean soup, boolean vegetarian, java.util.Date lastUsage, java.util.Date lastDrop, java.util.Date creationDate) {
        this.id = id;
        this.name = name;
        this.duration = duration;
        this.seasons = seasons;
        this.soup = soup;
        this.vegetarian = vegetarian;
        this.lastUsage = lastUsage;
        this.lastDrop = lastDrop;
        this.creationDate = creationDate;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getDinnerDao() : null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /** Not-null value. */
    public String getName() {
        return name;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getSeasons() {
        return seasons;
    }

    public void setSeasons(int seasons) {
        this.seasons = seasons;
    }

    public boolean getSoup() {
        return soup;
    }

    public void setSoup(boolean soup) {
        this.soup = soup;
    }

    public boolean getVegetarian() {
        return vegetarian;
    }

    public void setVegetarian(boolean vegetarian) {
        this.vegetarian = vegetarian;
    }

    public java.util.Date getLastUsage() {
        return lastUsage;
    }

    public void setLastUsage(java.util.Date lastUsage) {
        this.lastUsage = lastUsage;
    }

    public java.util.Date getLastDrop() {
        return lastDrop;
    }

    public void setLastDrop(java.util.Date lastDrop) {
        this.lastDrop = lastDrop;
    }

    /** Not-null value. */
    public java.util.Date getCreationDate() {
        return creationDate;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setCreationDate(java.util.Date creationDate) {
        this.creationDate = creationDate;
    }

    /** To-many relationship, resolved on first access (and after reset). Changes to to-many relations are not persisted, make changes to the target entity. */
    public List<DinnerStat> getDinnerIngredientDinner() {
        if (DinnerIngredientDinner == null) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            DinnerStatDao targetDao = daoSession.getDinnerStatDao();
            List<DinnerStat> DinnerIngredientDinnerNew = targetDao._queryDinner_DinnerIngredientDinner(id);
            synchronized (this) {
                if(DinnerIngredientDinner == null) {
                    DinnerIngredientDinner = DinnerIngredientDinnerNew;
                }
            }
        }
        return DinnerIngredientDinner;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    public synchronized void resetDinnerIngredientDinner() {
        DinnerIngredientDinner = null;
    }

    /** To-many relationship, resolved on first access (and after reset). Changes to to-many relations are not persisted, make changes to the target entity. */
    public List<DinnerIngredient> getDinnerIngredientToDinners() {
        if (DinnerIngredientToDinners == null) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            DinnerIngredientDao targetDao = daoSession.getDinnerIngredientDao();
            List<DinnerIngredient> DinnerIngredientToDinnersNew = targetDao._queryDinner_DinnerIngredientToDinners(id);
            synchronized (this) {
                if(DinnerIngredientToDinners == null) {
                    DinnerIngredientToDinners = DinnerIngredientToDinnersNew;
                }
            }
        }
        return DinnerIngredientToDinners;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    public synchronized void resetDinnerIngredientToDinners() {
        DinnerIngredientToDinners = null;
    }

    /** Convenient call for {@link AbstractDao#delete(Object)}. Entity must attached to an entity context. */
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.delete(this);
    }

    /** Convenient call for {@link AbstractDao#update(Object)}. Entity must attached to an entity context. */
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.update(this);
    }

    /** Convenient call for {@link AbstractDao#refresh(Object)}. Entity must attached to an entity context. */
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.refresh(this);
    }

}
