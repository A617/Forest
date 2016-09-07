package edu.nju.service;

import edu.nju.data.model.Role;
import edu.nju.data.model.Skill;
import edu.nju.service.vo.SkillVO;

import java.util.List;

/**
 * Created by tjDu on 2016/8/31.
 */

/**
 * 关于角色的接口方法
 */
public interface RoleService {
    /**
     * 选择角色
     *
     * @param userName
     * @param roleName
     */
    int selectRole(String userName, String roleName);

    /**
     * 展示角色包含的技能
     *
     * @param id
     * @return
     */
    List<SkillVO> showSkills(int id, String userName);

    /**
     * 升级角色中的某项技能
     *
     * @param roleName
     * @param skill
     * @param userName
     */
    int levelUp(String roleName, Skill skill, String userName);
    /**
     * 展示所有的角色
     * @return
     */
    List<Role> showAllRoles();

}
