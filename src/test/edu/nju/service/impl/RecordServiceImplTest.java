package edu.nju.service.impl;

import edu.nju.service.MemberService;
import edu.nju.service.RecordService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by Dora on 2016/10/10.
 */
@RunWith(SpringJUnit4ClassRunner.class)		//表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class RecordServiceImplTest {
    @Test
    public void getLearnCountsEveryday() throws Exception {
        System.out.println(service.getLearnCountsEveryday("14dtj"));
    }

    @Autowired
    RecordService service;

}