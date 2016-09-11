package edu.nju.service.vo;

import edu.nju.data.model.Skill;

import java.util.Date;

/**
 * Created by Dora on 2016/9/10.
 */
public class LevelUpRecordVO extends RecordVO {
    protected Skill skill;

    public LevelUpRecordVO(String username, Skill skill, Date time) {
        super(username,time);
        this.skill.setName(skill.getName());
        this.skill.setCatelog(skill.getCatelog());
        this.skill.setLevel(skill.getLevel());
        this.category = RecordCategory.levelup;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    @Override
    public String toString() {
        return "LevelUpRecordVO{" +
                "skill=" + skill +
                "} " + super.toString();
    }
}
