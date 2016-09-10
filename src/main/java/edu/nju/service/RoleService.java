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

    Role showRole(int id);

    Role showRole(String name);

    /**
     * 展示角色包含的技能以及该用户掌握情况（前提是用户选择的角色需要该技能）
     *
     * @param id
     * @return
     */
    List<SkillVO> showSkills(int id, String userName);

    /**
     * 展示所有的角色
     * @return
     */
    List<Role> showAllRoles();
    /**
     * 展示角色包含的技能
     * @return
     */
    List<Skill> showCommonSkills(int id);

}
