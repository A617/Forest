package edu.nju.data.dao;

import edu.nju.data.model.Repository;
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
}
