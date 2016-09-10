package edu.nju.data.mapping;

import edu.nju.data.dao.mapper.MemberMapper;
import edu.nju.data.dao.mapper.RepositoryMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Calendar;

@RunWith(SpringJUnit4ClassRunner.class)        //表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
/**
 * Created by fwtgm on 2016/9/1.
 */
public class MemberMapperTest {
    @Resource
    private MemberMapper dao;
    @Resource
    private RepositoryMapper repoMapper;

    @Test
    public void updateRoleTest() throws Exception {
        String name="dy";
        String role="doge";
        dao.updateRole(name,role);
    }
    @Test
    public void insertMemberSkillTest() throws Exception {
        String username="dy";
        String skill_name="OW";
        int level=0;
        java.sql.Date date;
        date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
//        dao.insertMemberSkill(username,skill_name,level,date);
    }

    @Test
    public void updateLevelTest() throws Exception {
        java.sql.Date date;
        date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        String username="dy";
        String skill_name="OW";
//        dao.updateLevel(skill_name,username,date);
    }

    @Test
    public void testGetLearnedRepo(){

       dao.getLearnedRepos("oraisdy");
    }

    @Test
    public void testGetAllSimpleRepos(){
        System.out.println(repoMapper.getAllSimpleRepo().size());
    }

    @Test
    public void testGetWatchers(){
        System.out.println(repoMapper.getWatchers("01org/appframework"));
    }

}
