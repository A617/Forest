package edu.nju.data.impl;

import edu.nju.data.model.Repository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by fwtgm on 2016/9/4.
 */
@RunWith(SpringJUnit4ClassRunner.class)        //表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})

public class RepoDaoImplTest {
    @Resource
    private RepoDaoImpl dao;

    @Test
    public void getRepoByFullNameTest() throws Exception {
        String name="11DH11/rpcs3";
        Repository r=dao.getReposByFullName(name);
        System.out.println(r.getHtml_url());
    }
    @Test
    public void learnRepository() throws Exception {
        String username="dy";
        String repo="01org/appframework";
        dao.learnRepository(username,repo);

    }

}