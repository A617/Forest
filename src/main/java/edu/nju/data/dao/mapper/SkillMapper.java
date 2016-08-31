package edu.nju.data.dao.mapper;

import edu.nju.data.model.Skill;
import edu.nju.data.model.SkillKey;

public interface SkillMapper {
    int deleteByPrimaryKey(SkillKey key);

    int insert(Skill record);

    int insertSelective(Skill record);

    Skill selectByPrimaryKey(SkillKey key);

    int updateByPrimaryKeySelective(Skill record);

    int updateByPrimaryKey(Skill record);
}