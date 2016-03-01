package biz.golek.whattodofordinner.business.contract.entities;

import java.util.Date;

/**
 * Created by bgolek on 2016-03-01.
 */
public class Dinner {
    private Long id;
    private String name;
    private Integer duration;
    private boolean soup;
    private boolean vegetarian;
    private boolean spring;
    private boolean summer;
    private boolean autumn;
    private boolean winter;
    private Date creationDate;
    private Date lastUsage;
    private Date lastDrop;

    public Dinner(String name, Integer duration, Boolean soup, Boolean vegetarian, Boolean spring, Boolean summer, Boolean autumn, Boolean winter) {
        this.name = name;
        this.duration = duration;
        this.soup = soup;
        this.vegetarian = vegetarian;
        this.spring = spring;
        this.summer = summer;
        this.autumn = autumn;
        this.winter = winter;
    }

    public Dinner(Long id, String name, Integer duration, boolean soup, boolean vegetarian, Boolean spring, Boolean summer, Boolean autumn, Boolean winter) {
        this(name, duration, soup, vegetarian, spring, summer, autumn, winter);
        this.id = id;
    }

    public Dinner(Long id, String name, int duration, boolean soup, boolean vegetarian, boolean spring, boolean summer, boolean autumn, boolean winter, Date creationDate) {
        this(id, name, duration, soup, vegetarian, spring, summer, autumn, winter);
        this.creationDate = creationDate;
    }

    public Dinner(Long id, String name, int duration, boolean soup, boolean vegetarian, boolean spring, boolean summer, boolean autumn, boolean winter, Date creationDate, Date lastUsage, Date lastDrop) {
        this(id, name, duration, soup, vegetarian, spring, summer, autumn, winter, creationDate);
        this.lastUsage = lastUsage;
        this.lastDrop = lastDrop;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public boolean getSoup() {
        return soup;
    }

    public boolean isSoup() {
        return soup;
    }

    public void setSoup(boolean soup) {
        this.soup = soup;
    }

    public boolean getVegetarian() {
        return vegetarian;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public void setVegetarian(boolean vegetarian) {
        this.vegetarian = vegetarian;
    }

    public boolean getSpring() {
        return spring;
    }

    public boolean isSpring() {
        return spring;
    }

    public void setSpring(boolean spring) {
        this.spring = spring;
    }

    public boolean getSummer() {
        return summer;
    }

    public boolean isSummer() {
        return summer;
    }

    public void setSummer(boolean summer) {
        this.summer = summer;
    }

    public boolean getAutumn() {
        return autumn;
    }

    public boolean isAutumn() {
        return autumn;
    }

    public void setAutumn(boolean autumn) {
        this.autumn = autumn;
    }

    public boolean getWinter() {
        return winter;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public Date getLastUsage() {
        return lastUsage;
    }

    public Date getLastDrop() {
        return lastDrop;
    }
}
