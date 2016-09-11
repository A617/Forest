package edu.nju.service.impl;

import edu.nju.data.model.MemberReport;
import edu.nju.service.MemberService;
import edu.nju.service.RepositoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Timestamp;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by st0001 on 2016/9/10.
 */
@RunWith(SpringJUnit4ClassRunner.class)		//表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class RepositoryServiceImplTest {
    @Test
    public void reportRepository() throws Exception {
        MemberReport report = new MemberReport("oraisdy", "ebidel/html5demos", 1, "", new Timestamp(new Date().getTime()));
        System.out.println(service.reportRepository(report));
    }

    @Autowired
    RepositoryService service;
}