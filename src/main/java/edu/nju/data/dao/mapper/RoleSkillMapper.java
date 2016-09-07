package edu.nju.data.dao.mapper;

import edu.nju.data.model.Role;
import edu.nju.data.model.RoleSkill;
import edu.nju.data.model.Skill;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleSkillMapper {
    int deleteByPrimaryKey(@Param("role") String role, @Param("skillName") String skillName, @Param("level") Integer level);

    int insert(RoleSkill record);

    int insertSelective(RoleSkill record);

    List<Skill> selectSkill(String role);
}