package edu.nju.service.vo;

import java.util.Date;

/**
 * Created by Dora on 2016/9/10.
 */
public class LevelUpRecordVO extends RecordVO {
    protected String skill_name;

    protected Integer level;

    public LevelUpRecordVO(String username, String skill_name, Integer level, Date time) {
        super(username,time);
        this.skill_name = skill_name;
        this.level = level;
        this.category = RecordCategory.levelup;
    }

    @Override
    public String toString() {
        return "LevelUpRecordVO{" +
                "skill_name='" + skill_name + '\'' +
                ", level=" + level +
                "} " + super.toString();
    }
}
