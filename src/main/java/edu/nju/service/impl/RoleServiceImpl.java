package edu.nju.service.impl;

import edu.nju.data.dao.IRoleDao;
import edu.nju.data.model.Skill;
import edu.nju.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by tjDu on 2016/9/5.
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Resource
    IRoleDao roleDao;

    @Override
    public void selectRole(String userName, String roleName) {
        roleDao.selectRole(userName, roleName);
    }

    @Override
    public List<Skill> showSkills(String roleName) {
        return roleDao.showSkills(roleName);
    }

    @Override
    public void levelUp(String roleName, Skill skill, String userName) {
        roleDao.levelUp(roleName, skill, userName);
    }
}
