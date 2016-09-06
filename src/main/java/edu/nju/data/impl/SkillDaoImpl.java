package edu.nju.data.impl;


import edu.nju.data.dao.ISkillDao;
import edu.nju.data.dao.mapper.RepositoryMapper;
import edu.nju.data.dao.mapper.SkillMapper;
import edu.nju.data.model.Repository;
import edu.nju.data.model.SimpleRepo;
import edu.nju.data.model.Skill;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
@org.springframework.stereotype.Repository("skillDao")
/**
 * Created by phoebegl on 2016/9/6.
 */
public class SkillDaoImpl implements ISkillDao {
    @Resource
    private SkillMapper mapper;

    @Override
    public List<SimpleRepo> showRecommendRepos(Skill skill) {
        return mapper.getSimpleRepo(skill.getName(),skill.getLevel());
    }
}