package edu.nju.data.Impl;

import edu.nju.data.dao.IMemberDao;
import edu.nju.data.dao.mapper.MemberMapper;
import edu.nju.data.dao.mapper.MemberReportMapper;
import edu.nju.data.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by tjDu on 2016/9/8.
 */
@Service("memberDao")
public class MemberDaoImpl implements IMemberDao {
    @Autowired
    private MemberMapper memberMapper;
    @Autowired
    private MemberReportMapper reportMapper;

    @Override
    public Member showMember(String username) {
        return memberMapper.searchMember(username);
    }

    @Override
    public boolean addMember(Member member) {
        int i = memberMapper.addMember(member);
        if (i > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int levelUp( Skill skill, String userName) {
        Date d = new Date();
        Timestamp date = new Timestamp(d.getTime());
        return memberMapper.insertMemberSkill(userName,skill.getName(),skill.getLevel()+1,date);
    }

    @Override
    public List<String> getLearnedRepos(String username) {
        return memberMapper.getLearnedRepos(username);
    }

    @Override
    public List<LevelUpRecord> getLevelUpRecordOfUser(String userName){

        return memberMapper.getLevelUpRecordOfUser(userName);
    }

    @Override
    public List<GraduateRecord> getGraduateRecordOfUser(String userName){
        return memberMapper.getGraduateRecordOfUser(userName);
    }

    @Override
    public List<MemberReport> getLearnRecordsOfUser(String userName){
        return reportMapper.getLearnRecordsOfUser(userName);
    }

    @Override
    public List<LearnCounts> getLearnCountsEveryday(String username) {
        return reportMapper.getLearnCountsEveryday(username);
    }
}
