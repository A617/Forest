package edu.nju.data.dao.mapper;

import edu.nju.data.model.RoleSkillKey;

public interface RoleSkillMapper {
    int deleteByPrimaryKey(RoleSkillKey key);

    int insert(RoleSkillKey record);

    int insertSelective(RoleSkillKey record);
}