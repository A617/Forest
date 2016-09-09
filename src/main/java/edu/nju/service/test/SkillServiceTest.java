package edu.nju.service.test;

import edu.nju.data.model.Skill;
import edu.nju.service.SkillService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by tjDu on 2016/9/9.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class SkillServiceTest {
    @Resource
    SkillService service;

    @Test
    public void testShowRecommendRepos(){
        Skill test = new Skill("CSS",2);
        System.out.println(service.showRecommendRepos(test,"tj"));
    }
}
