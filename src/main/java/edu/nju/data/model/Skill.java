package edu.nju.data.model;

public class Skill {
    private String name;

    private Integer level;

    private String catelog;

    public Skill(String name, Integer level, String catelog) {
        this.name = name;
        this.level = level;
        this.catelog = catelog;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getCatelog() {
        return catelog;
    }

    public void setCatelog(String catelog) {
        this.catelog = catelog;
    }
}