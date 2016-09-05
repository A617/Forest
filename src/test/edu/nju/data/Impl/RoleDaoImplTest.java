package edu.nju.data.impl;

import edu.nju.data.dao.IRoleDao;
import edu.nju.data.model.Skill;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by fwtgm on 2016/9/4.
 */
public class RoleDaoImplTest {
    @Resource
    private IRoleDao dao;
    @Test
    public void selectRole() throws Exception {

    }

    @Test
    public void showSkills() throws Exception {
        String name="Web Developer";
        List<Skill> list=dao.showSkills(name);
        for(Skill s:list){
            System.out.println(s.getName());
        }
    }

    @Test
    public void levelUp() throws Exception {

    }

}