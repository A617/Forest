package edu.nju.service;

import edu.nju.data.model.Role;
import edu.nju.data.model.Skill;

import java.util.List;

/**
 * Created by tjDu on 2016/8/31.
 */
public interface RoleService {
    /**
     * 选择角色
     *
     * @param userName
     * @param roleName
     */
    void selectRole(String userName, String roleName);

    /**
     * 展示角色包含的技能
     *
     * @param roleName
     * @return
     */
    List<Skill> showSkills(String roleName);


}
