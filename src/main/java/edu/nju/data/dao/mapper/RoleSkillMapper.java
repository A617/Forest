package edu.nju.data.dao.mapper;

import edu.nju.data.model.RoleSkill;
import org.apache.ibatis.annotations.Param;

public interface RoleSkillMapper {
    int deleteByPrimaryKey(@Param("role") String role, @Param("skillName") String skillName, @Param("level") Integer level);

    int insert(RoleSkill record);

    int insertSelective(RoleSkill record);
}