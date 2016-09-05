package edu.nju.data.impl;


import edu.nju.data.dao.ISkillDao;
import edu.nju.data.dao.mapper.SkillMapper;
import edu.nju.data.model.Repository;
import edu.nju.data.model.Skill;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fwtgm on 2016/9/1.
 */
public class SkillDaoImpl implements ISkillDao {
    @Resource
    private SkillMapper mapper;
    @Override
    public List<Repository> showRecommendRepos(Skill skill) {
        List<String> repo_name=mapper.getRepoName(skill.getName(),skill.getLevel());
        List<Repository>list=new ArrayList<Repository>();
        return null;
    }
}
