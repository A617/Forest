package edu.nju.service;

import edu.nju.data.model.Repository;
import edu.nju.data.model.SimpleRepo;
import edu.nju.data.model.Skill;

import java.util.List;

/**
 * Created by tjDu on 2016/8/31.
 */

public interface SkillService {
    /**
     * 根据技能展示推荐的仓库
     *
     * @param skill
     * @return
     */
    List<SimpleRepo> showRecommendRepos(Skill skill);
}
