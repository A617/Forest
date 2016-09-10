package edu.nju.service.vo;

import edu.nju.data.model.Skill;

/**
 * Created by tjDu on 2016/9/6.
 */
public class SkillVO extends Skill {

    /**
     * 用户当前的级别
     */
    private int userLevel;

    /**
     * 技能完成度 百分号前面的数
     */
    private int progress;
    /**
     * 该技能是否完成
     */
    private boolean status;

    public int getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(int userLevel) {
        this.userLevel = userLevel;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
