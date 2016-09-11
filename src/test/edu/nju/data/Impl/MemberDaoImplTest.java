package edu.nju.data.Impl;

import edu.nju.data.dao.IMemberDao;
import edu.nju.data.model.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Dora on 2016/9/10.
 */
@RunWith(SpringJUnit4ClassRunner.class)		//表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class MemberDaoImplTest {
    @Test
    public void levelUp() throws Exception {
        Date d = new Date();
        Timestamp date = new Timestamp(d.getTime());
        System.out.println(dao.levelUp(new Skill("CSS",0,"Web Front-end"),"tj"));
    }

    @Test
    public void showMember() throws Exception {
        System.out.println(dao.showMember("oppalu").getRole());
    }

    @Test
    public void addMember() throws Exception {
    }

    @Test
    public void getLearnedRepos() throws Exception {

        System.out.println(dao.getLearnedRepos("oraisdy"));
    }

    @Test
    public void getReport() throws Exception {
        List<MemberReport> list = dao.getLearnRecordsOfUser("oraisdy");

        for(MemberReport m : list)
            System.out.println(m.getEvaluate()+" "+m.getTime());

    }

    @Test
    public void getLevelReport() throws Exception {
        List<LevelUpRecord> list = dao.getLevelUpRecordOfUser("oraisdy");
        for(LevelUpRecord l : list) {
            System.out.println(l.getSkill_name()+" "+l.getLevel()+" "+l.getTime());
        }
    }

    @Test
    public void getGraduateReport() throws Exception {
        List<GraduateRecord> list = dao.getGraduateRecordOfUser("oppalu");

        for(GraduateRecord l : list) {
            System.out.println(l.getRole()+" "+l.getTime());
        }
    }

    @Autowired
    IMemberDao dao;
}