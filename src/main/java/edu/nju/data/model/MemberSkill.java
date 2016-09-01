package edu.nju.data.model;

import java.util.Date;

/**
 * Created by fwtgm on 2016/9/1.
 */
public class MemberSkill {
    private String username;

    private String skill_name;

    private int level;

    private Date time;

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

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
