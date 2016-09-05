package edu.nju.data.dao;

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
    List<SimpleRepo> showRecommendRepos(Skill skill);
}
