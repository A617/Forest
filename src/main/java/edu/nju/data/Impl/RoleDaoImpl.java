package edu.nju.data.Impl;

import edu.nju.data.dao.IRoleDao;
import edu.nju.data.dao.mapper.MemberMapper;
import edu.nju.data.dao.mapper.RoleMapper;
import edu.nju.data.dao.mapper.RoleSkillMapper;
import edu.nju.data.dao.mapper.SkillMapper;
import edu.nju.data.model.Role;
import edu.nju.data.model.Skill;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
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
    private RoleMapper roleMapper;

    @Override
    public int selectRole(String userName, String roleName) {
        List<Skill> needs = roleSkillMapper.selectSkill(roleName);
        Date d = new Date();
        Timestamp date = new Timestamp(d.getTime());
        for(Skill need: needs){
            memberMapper.insertMemberSkill(userName,need.getName(),0,date);
        }
        return memberMapper.updateRole(userName, roleName);
    }

    @Override
    public Role selectRoleById(int id){
        return roleMapper.selectByPrimaryKey(id);
    }

    @Override
    public Role selectRoleByName(String name) {
        return roleMapper.selectRoleByName(name);
    }

    @Override
    public List<Skill> showSkills(String roleName) {
        return roleSkillMapper.selectSkill(roleName);
    }


    @Override
    public List<Role> showAllRoles() {
        return roleMapper.showAll();
    }
}
