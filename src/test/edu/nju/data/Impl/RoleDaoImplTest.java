package edu.nju.data.Impl;

import edu.nju.data.dao.IRoleDao;
import edu.nju.data.model.GraduateRecord;
import edu.nju.data.model.Role;
import edu.nju.data.model.Skill;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * Created by fwtgm on 2016/9/4.
 */
@RunWith(SpringJUnit4ClassRunner.class)        //表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})

public class RoleDaoImplTest {
    @Test
    public void selectRoleByName() throws Exception {
        System.out.println(dao.selectRoleByName("Web Developer"));
    }

    @Test
    public void selectRoleById() throws Exception {
        System.out.println(dao.selectRoleById(1));
    }

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
    public void showAllRoles() throws Exception {
        List<Role> list = dao.showAllRoles();
        for(Role r : list){
            System.out.println(r.getName());
        }
    }

    @Test
    public void testAddRecord() {
        Date d = new Date();
        Timestamp date = new Timestamp(d.getTime());
        GraduateRecord record = new GraduateRecord("phoebegl","Web Developer",date);
        System.out.print(dao.addGraduateRecordOfGoal(record));
    }

    @Test
    public void testGetRecord() {
        List<GraduateRecord> list = dao.getGraduateRecordOfGoal("Web Developer");
        for(GraduateRecord g :list) {
            System.out.println(g.getUsername()+" "+g.getTime());
        }
    }

}