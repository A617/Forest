package edu.nju.data.Impl;


import edu.nju.data.dao.ISkillDao;
import edu.nju.data.dao.mapper.SkillMapper;
import edu.nju.data.model.Repository;
import edu.nju.data.model.Skill;

import javax.annotation.Resource;
import java.util.List;
@org.springframework.stereotype.Repository("skillDao")
/**
 * Created by phoebegl on 2016/9/6.
 */
public class SkillDaoImpl implements ISkillDao {
    @Resource
    private SkillMapper mapper;

    @Override
    public List<Repository> showRecommendRepos(Skill skill) {
        return mapper.getRepo(skill.getName(),skill.getLevel());
    }

    @Override
    public List<Skill> getUserMasterSkills(String userName) {

        return mapper.getUserMasterSkills(userName);
    }

    @Override
    public List<String> getAllSkillNames() {
        return mapper.getAllSkills();
    }
}