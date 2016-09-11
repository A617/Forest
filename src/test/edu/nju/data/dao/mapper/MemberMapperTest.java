package edu.nju.data.dao.mapper;

import edu.nju.data.model.Member;
import edu.nju.data.model.ReportRecord;
import edu.nju.data.model.Role;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by fwtgm on 2016/9/6.
 */
@RunWith(SpringJUnit4ClassRunner.class)        //表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})

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
        Date d = new Date();
        Timestamp date = new Timestamp(d.getTime());
        dao.insertMemberSkill(username,skill_name,level,date);
    }

    @Test
    public void updateLevelTest() throws Exception {
        Date d = new Date();
        Timestamp date = new Timestamp(d.getTime());
        dao.insertMemberSkill("tj","CSS",0,date);
    }

    @Test
    public void testGetLearnedRepo(){

        dao.getLearnedRepos("oraisdy");
    }

    @Test
    public void testGetAllSimpleRepos(){
        System.out.println(repoMapper.getAllSimpleRepo().size());
    }

}