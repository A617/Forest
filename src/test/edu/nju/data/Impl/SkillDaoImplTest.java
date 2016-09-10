package edu.nju.data.Impl;

import edu.nju.data.model.Repository;
import edu.nju.data.model.Skill;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)        //表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})

public class SkillDaoImplTest {

    @Resource
    private SkillDaoImpl dao;

    @Test
    public void getRepoNameTest() throws Exception {
        Skill skill = new Skill("Java",2,"Programming Language");

        List<Repository> repo = dao.showRecommendRepos(skill);
        for(Repository s : repo){
            System.out.println(s.getName()+" "+s.getHtml_url());
        }
    }

    @Test
    public void getUserMasterSkillsTest() throws Exception {

        List<Skill> list = dao.getUserMasterSkills("oraisdy");
        for(Skill s : list)
            System.out.println(s.getName()+" "+s.getLevel());
    }

    @Test
    public void getSkillsTest() throws Exception {
        Skill s = dao.getSkills("Web Developer","CSS");
        System.out.println(s.getName()+" "+s.getLevel()+" "+s.getCatelog());
    }


}