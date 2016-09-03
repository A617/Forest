package edu.nju.data.mapping;

import edu.nju.data.dao.mapper.RoleSkillMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)        //表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})

/**
 * Created by fwtgm on 2016/9/3.
 */
public class RoleSkillMapperTest {
    @Resource
    private RoleSkillMapper dao;


    @Test
    public void selectSkillNameTest() throws Exception {
        String role="Web Developer";
        List<String> list=dao.selectSkillName(role);
        for(String s:list){
            System.out.println(s);
        }
    }
}
