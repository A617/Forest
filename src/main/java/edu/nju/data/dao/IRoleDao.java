package edu.nju.data.dao;

import edu.nju.data.model.Member;
import edu.nju.data.model.Role;
import edu.nju.data.model.Skill;

import java.util.List;

/**
 * Created by tjDu on 2016/9/1.
 */
public interface IRoleDao {
    /**
     * 选择角色
     *
     * @param userName
     * @param roleName
     */
    int selectRole(String userName, String roleName);

    Role selectRoleById(int id);

    Role selectRoleByName(String name);

    /**
     * 展示角色包含的技能
     *
     * @param roleName
     * @return
     */
    List<Skill> showSkills(String roleName);


    /**
     * 展示所有的角色
     * @return
     */
    List<Role> showAllRoles();
}
