package edu.nju.service.test;

import edu.nju.service.RoleService;
import edu.nju.service.vo.SkillVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by tjDu on 2016/9/7.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class RoleServiceTest {
    @Resource
    private RoleService service;

    @Test
    public void testShowSkills() {
        String userName = "oraisdy";
        System.out.println(service.showSkills(1, userName));
    }

    @Test
    public void testSelectRole() {
        service.selectRole("tj", "Web Developer");
    }

    @Test
    public void testGetUserMasterSkills() {
        for(SkillVO vo: service.getUserMasterSkills("tj")){
            System.out.println(vo.getName()+":"+"userLevel:"+vo.getUserLevel()+",skillLevel:"+vo.getLevel());
        }
    }
}
