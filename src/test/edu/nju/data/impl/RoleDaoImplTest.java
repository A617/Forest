package edu.nju.data.impl;

import edu.nju.data.dao.IRoleDao;
import edu.nju.data.model.Skill;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by fwtgm on 2016/9/4.
 */
@RunWith(SpringJUnit4ClassRunner.class)        //表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})

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