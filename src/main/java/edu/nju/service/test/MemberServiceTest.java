package edu.nju.service.test;

import edu.nju.data.model.Member;
import edu.nju.service.MemberService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by tjDu on 2016/9/8.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class MemberServiceTest {
    @Resource
    private MemberService service;

    @Test
    public void testAddMember(){
        service.createMember(new Member("dtj","Web Developer"));
    }

    @Test
    public void testShowMember(){
        System.out.println(service.showMember("dy"));
    }

}
