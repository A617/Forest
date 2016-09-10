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
    public Role showRole(int id) {
        return roleDao.selectRoleById(id);
    }

    @Override
    public Role showRole(String name) {
        return roleDao.selectRoleByName(name);
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
                    vo.setName(name);
                    vo.setUserLevel(level);
                    vo.setLevel(need.getLevel());
                    vo.setCatelog(need.getCatelog());
                    vo.setProgress((int)(vo.getUserLevel() * 1.0 / vo.getLevel() * 100));
                    if (vo.getProgress() >= 1) {
                        vo.setStatus(true);
                    } else {
                        vo.setStatus(false);
                    }
                    result.add(vo);
                    break;
                }
            }
        }
        return result;
    }



    @Override
    public List<Role> showAllRoles() {
        return roleDao.showAllRoles();
    }

    @Override
    public List<Skill> showCommonSkills(int id) {
        return roleDao.showSkills(roleDao.selectRoleById(id).getName());
    }
}
