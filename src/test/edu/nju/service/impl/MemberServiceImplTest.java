package edu.nju.service.impl;

import edu.nju.service.MemberService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by Dora on 2016/9/8.
 */
@RunWith(SpringJUnit4ClassRunner.class)		//表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class MemberServiceImplTest {
    @Test
    public void getUserDetail() throws Exception {

        System.out.println(service.getUserDetail("njushishuo","fb6f267f906faba3d59eace5376739ed737512ed"));
    }

    @Autowired
    MemberService service;

    @Test
    public void showMember() throws Exception {
        System.out.println(service.showMember("oraisdy"));
    }

}