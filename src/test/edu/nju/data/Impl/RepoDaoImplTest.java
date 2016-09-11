package edu.nju.data.Impl;

import edu.nju.data.model.MemberReport;
import edu.nju.data.model.ReportRecord;
import edu.nju.data.model.Repository;
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
 * Created by fwtgm on 2016/9/4.
 */
@RunWith(SpringJUnit4ClassRunner.class)        //表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})

public class RepoDaoImplTest {
    @Resource
    private RepoDaoImpl dao;

    @Test
    public void getRepoByFullNameTest() throws Exception {
        String name="11DH11/rpcs3";
        Repository r=dao.getReposByFullName(name);
        System.out.println(r.getHtml_url());
    }
    @Test
    public void learnRepository() throws Exception {
        String username="dy";
        String repo="01org/appframework";
        dao.learnRepository(username,repo);

    }
    @Test
    public void reportRepository() throws Exception {
        String username="dy";
        String repo="01org/appframework";
        Date d = new Date();
        Timestamp date = new Timestamp(d.getTime());
        MemberReport mr=new MemberReport(username,repo,1,"fire in the hole!",date);
        dao.reportRepository(mr);
    }

    @Test
    public void testGetReport(){
        List<MemberReport> list = dao.getLearnRecordsOfRepo("benschwarz/gallery-css");
        for(MemberReport r :list)
            System.out.println(r.getUsername()+" "+r.getTime());
    }

}