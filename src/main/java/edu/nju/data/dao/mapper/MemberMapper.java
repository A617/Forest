package edu.nju.data.dao.mapper;

import edu.nju.data.model.GraduateRecord;
import edu.nju.data.model.LevelUpRecord;
import edu.nju.data.model.Member;
import edu.nju.data.model.MemberReport;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

public interface MemberMapper {
    int deleteByPrimaryKey(String username);

    int insert(Member record);

    int insertSelective(Member record);

    Member selectByPrimaryKey(String username);

    int updateByPrimaryKeySelective(Member record);

    int updateByPrimaryKey(Member record);

    int updateRole(String username,String role);

    int updateLevel(String skill_name,String username,Timestamp  date);

    int insertMemberSkill(String username,String skill_name,int level,Timestamp time);

    Member searchMember(String username);

    int addMember(Member member);

    List<String> getLearnedRepos(String username);

    List<LevelUpRecord> getLevelUpRecordOfUser(String userName);

    List<GraduateRecord> getGraduateRecordOfUser(String userName);

}