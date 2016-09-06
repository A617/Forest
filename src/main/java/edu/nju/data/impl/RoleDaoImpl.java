package edu.nju.data.impl;

import edu.nju.data.dao.IRoleDao;
import edu.nju.data.dao.mapper.MemberMapper;
import edu.nju.data.dao.mapper.RoleMapper;
import edu.nju.data.dao.mapper.RoleSkillMapper;
import edu.nju.data.dao.mapper.SkillMapper;
import edu.nju.data.model.Member;
import edu.nju.data.model.Role;
import edu.nju.data.model.Skill;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@org.springframework.stereotype.Repository("roleDao")
/**
 * Created by fwtgm on 2016/9/1.
 */

public class RoleDaoImpl implements IRoleDao {
    @Resource
    private MemberMapper mapper;
    @Resource
    private RoleSkillMapper mapper2;
    @Resource
    private SkillMapper mapper3;
    @Resource
    private RoleMapper mapper4;

    @Override
    public int selectRole(String userName, String roleName) {
        return mapper.updateRole(userName, roleName);
    }

    @Override
    public List<Skill> showSkills(String roleName) {
        List<String> list = mapper2.selectSkillName(roleName);
        List<Skill> result = new ArrayList<Skill>();
        for (String str : list) {
            List<String> catelog = mapper3.selectCatelog(str);
            List<Integer> level = mapper3.selectLevel(str);
            for (int i = 0; i < level.size(); i++) {
                Skill skill = new Skill(str, level.get(i), catelog.get(i));
                result.add(skill);
            }
        }
        return result;
    }

    @Override
    public int levelUp(String roleName, Skill skill, String userName) {
        java.sql.Date date;
        date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        return mapper.updateLevel(skill.getName(), userName, date);
    }

    @Override
    public List<Role> showAllRoles() {
        return mapper4.showAll();
    }

    @Override
    public Member showMember(String username) {
        return mapper.searchMember(username);
    }

    @Override
    public String addMember(Member member) {
        String result = "";
        String name = member.getUsername();
        Member data = mapper.searchMember(name);
        if (data != null) {
            result = "用户名重复";
            return result;
        } else {
            if (member.getPassword().length() < 6) {
                result = "密码长度要大于等于6";
                return result;
            } else {
                mapper.addMember(member);
                return null;
            }

        }
    }
}
