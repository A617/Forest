package edu.nju.service.vo;

/**
 * Created by tjDu on 2016/9/6.
 */
public class SkillVO {
    /**
     * 技能的名字
     */
    public String skillName;
    /**
     * 用户当前的级别
     */
    public int userLevel;
    /**
     * 完成该技能需要达到的总级别
     */
    public int skillLevel;
    /**
     * 技能完成度
     */
    public double progress;
    /**
     * 该技能是否完成
     */
    public boolean status;
    /**
     * 技能分类
     */
    public String category;

    @Override
    public String toString() {
        return "SkillVO{" +
                "skillName='" + skillName + '\'' +
                ", userLevel=" + userLevel +
                ", skillLevel=" + skillLevel +
                ", progress=" + progress +
                ", status=" + status +
                ", category='" + category + '\'' +
                '}';
    }
}
