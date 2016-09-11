package edu.nju.data.model;

import java.sql.Timestamp;
import java.util.Date;

public class LevelUpRecord {
    protected String username;

    protected String skill_name;

    protected Integer level;

    protected Timestamp time;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSkill_name() {
        return skill_name;
    }

    public void setSkill_name(String skill_name) {
        this.skill_name = skill_name;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "LevelUpRecord{" +
                "username='" + username + '\'' +
                ", skill_name='" + skill_name + '\'' +
                ", level=" + level +
                ", time=" + time +
                '}';
    }
}