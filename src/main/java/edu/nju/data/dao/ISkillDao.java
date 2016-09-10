package edu.nju.data.dao;

import edu.nju.data.model.Repository;
import edu.nju.data.model.SimpleRepo;
import edu.nju.data.model.Skill;

import java.util.List;

/**
 * Created by fwtgm on 2016/9/1.
 */
public interface ISkillDao {
    /**
     * 根据技能展示推荐的仓库
     *
     * @param skill
     * @return
     */
    List<Repository> showRecommendRepos(Skill skill);

    /**
     * 拿到用户当前技能掌握的情况(查询member_skill)
     * @param userName
     * @return
     */
    List<Skill> getUserMasterSkills(String userName);

    /**
     * 根据角色名和技能的名字得到skill
     * @param rolename
     * @param skillName
     * @return
     */
    Skill getSkills(String rolename,String skillName);
}
