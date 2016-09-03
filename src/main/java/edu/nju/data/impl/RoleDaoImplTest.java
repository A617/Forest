package edu.nju.data.impl;

import edu.nju.data.dao.IRoleDao;
import edu.nju.data.model.Skill;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)        //表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
/**
 * Created by fwtgm on 2016/9/3.
 */
public class RoleDaoImplTest {
    @Resource
    private IRoleDao dao;
    @Test
    public void showSkillsTest() throws Exception {
        String name="Web Developer";
        List<Skill> list=dao.showSkills(name);
        for(Skill s:list){
            System.out.println(s.getName());
        }
    }

}
