package edu.nju.data.dao;

import edu.nju.data.model.Repository;
import edu.nju.data.model.Skill;

import java.util.List;

/**
 * Created by tjDu on 2016/8/31.
 */
public interface ISkillDao {
    /**
     * 根据技能展示推荐的仓库
     *
     * @param skill
     * @return
     */
    List<Repository> showRecommendRepos(Skill skill);
}
