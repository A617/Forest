package edu.nju.data.Impl;

import edu.nju.data.dao.IRoleDao;
import edu.nju.data.dao.mapper.MemberMapper;
import edu.nju.data.dao.mapper.RoleMapper;
import edu.nju.data.dao.mapper.RoleSkillMapper;
import edu.nju.data.dao.mapper.SkillMapper;
import edu.nju.data.model.Role;
import edu.nju.data.model.Skill;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.List;

@org.springframework.stereotype.Repository("roleDao")
/**
 * Created by fwtgm on 2016/9/1.
 */

public class RoleDaoImpl implements IRoleDao {
    @Resource
    private MemberMapper memberMapper;
    @Resource
    private RoleSkillMapper roleSkillMapper;
    @Resource
    private SkillMapper skillMapper;
    @Resource
    private RoleMapper roleMapper;

    @Override
    public int selectRole(String userName, String roleName) {
        return memberMapper.updateRole(userName, roleName);
    }

    @Override
    public Role selectRoleById(int id) {
        Role r=roleMapper.selectRoleById(id);
        return r;
    }

    @Override
    public List<Skill> showSkills(String roleName) {
        return roleSkillMapper.selectSkill(roleName);
    }

    @Override
    public int levelUp(String roleName, Skill skill, String userName) {
        java.sql.Date date;
        date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        return memberMapper.updateLevel(skill.getName(), userName, date);
    }

    @Override
    public List<Role> showAllRoles() {
        return roleMapper.showAll();
    }
}
