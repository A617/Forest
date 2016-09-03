package edu.nju.data.impl;

import edu.nju.data.dao.IRoleDao;
import edu.nju.data.dao.mapper.MemberMapper;
import edu.nju.data.dao.mapper.RoleSkillMapper;
import edu.nju.data.dao.mapper.SkillMapper;
import edu.nju.data.model.Skill;

import javax.annotation.Resource;
import java.util.ArrayList;
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
    private RoleSkillMapper mapper2;
    @Resource
    private SkillMapper mapper3;

    @Override
    public void selectRole(String userName, String roleName) {
    mapper.updateRole(userName,roleName);
    }

    @Override
    public List<Skill> showSkills(String roleName) {
        List<String>list=mapper2.selectSkillName(roleName);
        List<Skill>result=new ArrayList<Skill>();
        for(String str:list){
            List<String> catelog=mapper3.selectCatelog(str);
            List<Integer> level=mapper3.selectLevel(str);
            for(int i=0;i<level.size();i++){
                Skill skill=new Skill(str,level.get(i),catelog.get(i));
                result.add(skill);
            }
        }
        return result;
    }

    @Override
    public void levelUp(String roleName, Skill skill, String userName) {
        java.sql.Date date;
        date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        mapper.updateLevel(skill.getName(),userName,date);

    }
}
