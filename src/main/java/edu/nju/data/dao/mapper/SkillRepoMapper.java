package edu.nju.data.dao.mapper;

import edu.nju.data.model.SkillRepo;

public interface SkillRepoMapper {
    int deleteByPrimaryKey(String skill);

    int insert(SkillRepo record);

    int insertSelective(SkillRepo record);

    SkillRepo selectByPrimaryKey(String skill);

    int updateByPrimaryKeySelective(SkillRepo record);

    int updateByPrimaryKey(SkillRepo record);
}