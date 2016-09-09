package edu.nju.service.impl;

import edu.nju.data.model.Skill;
import edu.nju.service.SkillService;
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
public class SkillServiceImplTest {
    @Test
    public void showRecommendRepos() throws Exception {

        System.out.println(service.showRecommendRepos(new Skill("CSS",2),"oraisdy"));
    }

    @Autowired
    SkillService service;
}