package edu.nju.service;

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
    List<Repository> showRecommendRepos(Skill skill);
}
