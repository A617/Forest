package edu.nju.data.Impl;

import edu.nju.data.dao.IMemberDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by Dora on 2016/9/10.
 */
@RunWith(SpringJUnit4ClassRunner.class)		//表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class MemberDaoImplTest {
    @Test
    public void levelUp() throws Exception {

    }

    @Test
    public void showMember() throws Exception {

    }

    @Test
    public void addMember() throws Exception {

    }

    @Test
    public void getLearnedRepos() throws Exception {

        System.out.println(dao.getLearnedRepos("oraisdy"));
    }

    @Autowired
    IMemberDao dao;
}