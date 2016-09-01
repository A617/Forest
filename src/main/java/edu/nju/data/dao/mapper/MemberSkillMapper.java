package edu.nju.data.dao.mapper;

import edu.nju.data.model.Member;

import java.sql.Date;

public interface MemberSkillMapper {
    int deleteByPrimaryKey(String username);

    int insert(Member record);

    int insertSelective(Member record);

    Member selectByPrimaryKey(String username);

    int updateByPrimaryKeySelective(Member record);

    int updateByPrimaryKey(Member record);

    void levelUp(String roleName,String skillName, String userName,Date time);
}