package edu.nju.service.impl;

import edu.nju.data.dao.IRoleDao;
import edu.nju.data.dao.ISkillDao;
import edu.nju.data.model.Role;
import edu.nju.data.model.Skill;
import edu.nju.service.RoleService;
import edu.nju.service.vo.SkillVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tjDu on 2016/9/5.
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Resource
    IRoleDao roleDao;
    @Resource
    ISkillDao skillDao;

    @Override
    public int selectRole(String userName, String roleName) {
        return roleDao.selectRole(userName, roleName);
    }

    @Override
    public List<SkillVO> showSkills(int id, String userName) {
        List<SkillVO> result = new ArrayList<>();
        List<Skill> list = roleDao.showSkills(roleDao.selectRoleById(id).getName());
        List<Skill> masterList = skillDao.getUserMasterSkills(userName);
        for (Skill master : masterList) {
            int level = master.getLevel();
            String name = master.getName();
            SkillVO vo = new SkillVO();
            for (Skill need : list) {
                if (need.getName().equals(name)) {
                    vo.skillName = name;
                    vo.userLevel = level;
                    vo.skillLevel = need.getLevel();
                    vo.category = need.getCatelog();
                    vo.progress = vo.userLevel * 1.0 / vo.skillLevel;
                    if (vo.progress >= 1) {
                        vo.status = true;
                    } else {
                        vo.status = false;
                    }
                    break;
                }
                result.add(vo);
            }
        }
        return result;
    }

    @Override
    public int levelUp(String roleName, Skill skill, String userName) {
        return roleDao.levelUp(roleName, skill, userName);
    }

    @Override
    public List<Role> showAllRoles() {
        return roleDao.showAllRoles();
    }
}
