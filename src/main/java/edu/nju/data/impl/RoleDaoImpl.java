package edu.nju.data.impl;

import edu.nju.data.dao.IRoleDao;
import edu.nju.data.model.Skill;

import java.util.List;

@org.springframework.stereotype.Repository("roleDao")
/**
 * Created by fwtgm on 2016/9/1.
 */
public class RoleDaoImpl implements IRoleDao{

    @Override
    public void selectRole(String userName, String roleName) {

    }

    @Override
    public List<Skill> showSkills(String roleName) {
        return null;
    }

    @Override
    public void levelUp(String roleName, Skill skill, String userName) {

    }
}
