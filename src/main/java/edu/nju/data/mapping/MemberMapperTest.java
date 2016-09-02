package edu.nju.data.mapping;

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
public class MemberMapperTest {
    @Resource
    private MemberMapper dao;

    @Test
    public void updateRoleTest() throws Exception {
        String name="dy";
        String role="doge";
        dao.updateRole(name,role);
    }
}
