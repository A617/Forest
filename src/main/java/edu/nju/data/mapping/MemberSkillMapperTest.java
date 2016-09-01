package edu.nju.data.mapping;

import edu.nju.data.dao.mapper.MemberSkillMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)        //表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
/**
 * Created by fwtgm on 2016/9/1.
 */
public class MemberSkillMapperTest {
    @Resource
    private MemberSkillMapper dao;

    @Test
    public void levelUpTest() throws Exception {
//        String name="dy";
//        dao.levelUp("doge","bark");
    }
}
