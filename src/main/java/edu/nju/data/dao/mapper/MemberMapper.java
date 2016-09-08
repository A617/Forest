package edu.nju.data.dao.mapper;

import edu.nju.data.model.Member;

import java.sql.Date;

public interface MemberMapper {
    int deleteByPrimaryKey(String username);

    int insert(Member record);

    int insertSelective(Member record);

    Member selectByPrimaryKey(String username);

    int updateByPrimaryKeySelective(Member record);

    int updateByPrimaryKey(Member record);

    int updateRole(String username,String role);

    int updateLevel(String skill_name,String username,Date date);

    int insertMemberSkill(String username,String skill_name,int level,Date time);

    Member searchMember(String username);

    int addMember(Member member);

}