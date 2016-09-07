package edu.nju.data.dao.mapper;

import edu.nju.data.model.Repository;
import edu.nju.data.model.SimpleRepo;
import edu.nju.data.model.Skill;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SkillMapper {
    int deleteByPrimaryKey(@Param("name") String name, @Param("level") Integer level);

    int insert(Skill record);

    int insertSelective(Skill record);

    Skill selectByPrimaryKey(@Param("name") String name, @Param("level") Integer level);

    int updateByPrimaryKeySelective(Skill record);

    int updateByPrimaryKey(Skill record);

    List<String> selectCatelog(String name);

    List<Integer> selectLevel(String name);

    List<String> getRepoName(String skill_name,int level);

    List<Repository> getRepo(String skill_name, int level);

    List<Skill> getUserMasterSkills(String username);
}