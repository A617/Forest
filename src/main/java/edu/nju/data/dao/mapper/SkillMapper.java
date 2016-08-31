package edu.nju.data.dao.mapper;

import edu.nju.data.model.Skill;
import org.apache.ibatis.annotations.Param;

public interface SkillMapper {
    int deleteByPrimaryKey(@Param("name") String name, @Param("level") Integer level);

    int insert(Skill record);

    int insertSelective(Skill record);

    Skill selectByPrimaryKey(@Param("name") String name, @Param("level") Integer level);

    int updateByPrimaryKeySelective(Skill record);

    int updateByPrimaryKey(Skill record);
}