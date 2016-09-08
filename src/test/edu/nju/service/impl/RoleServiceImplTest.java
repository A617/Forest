package edu.nju.service.impl;

import edu.nju.service.RoleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by st0001 on 2016/9/8.
 */
@RunWith(SpringJUnit4ClassRunner.class)		//表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class RoleServiceImplTest {

    @Autowired
    RoleService roleService;

    @Test
    public void showSkills() throws Exception {
        System.out.println(roleService.showSkills(1,"oraisdy"));
    }

}