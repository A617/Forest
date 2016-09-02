package edu.nju.data.dao;

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
    void selectRole(String userName, String roleName);

    /**
     * 展示角色包含的技能
     *
     * @param roleName
     * @return
     */
    List<Skill> showSkills(String roleName);

    /**
     * 升级角色中的某项技能
     *
     * @param roleName
     * @param skill
     * @param userName
     */
    void levelUp(String roleName, Skill skill, String userName);
}
