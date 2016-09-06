package edu.nju.data.impl;

import edu.nju.data.dao.ISkillDao;
import edu.nju.data.dao.mapper.RepositoryMapper;
import edu.nju.data.dao.mapper.SkillMapper;
import edu.nju.data.model.Repository;
import edu.nju.data.model.SimpleRepo;
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

        List<SimpleRepo> repo = dao.showRecommendRepos(skill);
        for(SimpleRepo s : repo){
            System.out.println(s.getName()+ " " + s.getHtml_url());
        }
    }


}