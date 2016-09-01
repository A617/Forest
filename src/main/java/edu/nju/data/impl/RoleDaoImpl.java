package edu.nju.data.impl;

import edu.nju.data.dao.IRoleDao;
import edu.nju.data.dao.mapper.MemberMapper;
import edu.nju.data.dao.mapper.MemberSkillMapper;
import edu.nju.data.model.Skill;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.List;

@org.springframework.stereotype.Repository("roleDao")
/**
 * Created by fwtgm on 2016/9/1.
 */
public class RoleDaoImpl implements IRoleDao{
    @Resource
    private MemberMapper mapper;
    @Resource
    private MemberSkillMapper mapper2;

    @Override
    public void selectRole(String userName, String roleName) {
    mapper.updateRole(userName,roleName);
    }

    @Override
    public List<Skill> showSkills(String roleName) {
        return null;
    }

    @Override
    public void levelUp(String roleName, Skill skill, String userName) {
        java.sql.Date date;

        date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        java.util.Date d=new java.util.Date (date.getTime());
        mapper2.levelUp(roleName,skill.getName(),userName,date);

    }
}
