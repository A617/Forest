package edu.nju.data.Impl;

import edu.nju.data.dao.IMemberDao;
import edu.nju.data.dao.mapper.MemberMapper;
import edu.nju.data.model.Member;
import edu.nju.data.model.Skill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

/**
 * Created by tjDu on 2016/9/8.
 */
@Service("memberDao")
public class MemberDaoImpl implements IMemberDao {
    @Autowired
    private MemberMapper memberMapper;

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
        java.sql.Date date;
        date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        return memberMapper.updateLevel(skill.getName(), userName, date);
    }

    @Override
    public List<String> getLearnedRepos(String username) {
        return memberMapper.getLearnedRepos(username);
    }
}
