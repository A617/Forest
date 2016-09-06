package edu.nju.service.impl;

import edu.nju.data.dao.IRoleDao;
import edu.nju.data.model.Role;
import edu.nju.data.model.Skill;
import edu.nju.service.RoleService;
import edu.nju.service.vo.SkillVO;
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
    public int selectRole(String userName, String roleName) {
        roleDao.selectRole(userName, roleName);
        return 1;
    }

    @Override
    public List<SkillVO> showSkills(String roleName, String userName) {
        return null;
    }

    @Override
    public int levelUp(String roleName, Skill skill, String userName) {
        roleDao.levelUp(roleName, skill, userName);
        return 1;
    }

    @Override
    public List<Role> showAllRoles() {
        return roleDao.showAllRoles();
    }
}
