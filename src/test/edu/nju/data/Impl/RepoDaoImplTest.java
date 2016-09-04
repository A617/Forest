package edu.nju.data.Impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.nju.data.impl.RepoDaoImpl;
import edu.nju.data.model.Repository;
import edu.nju.data.task.HttpRequest;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * Created by fwtgm on 2016/9/4.
 */
public class RepoDaoImplTest {
    @Resource
    private RepoDaoImpl dao;
    @Test
    public void getContributorsScore() throws Exception {

        System.out.println(dao.getContributorsScore("kubespray/ kargo"));
    }

    @Test
    public void getSizeScore_extern1() throws Exception {

        System.out.println(dao.getSizeScore(88888,""));

    }

    @Test
    public void getSizeScore_extern() throws Exception {

        String repo = "api.github.com/repos/canadaduane/house";
        String s = HttpRequest.getGithubContentUsingHttpClient(repo);
        ObjectMapper mapper = new ObjectMapper();
        Repository po = mapper.readValue(s, Repository.class);

        System.out.println(dao.getSizeScore(po.getSize(),po.getLanguage()));
        System.out.println(dao.getContributorsScore_extern(256));
        System.out.println(dao.getHotScore(po.getStargazers_count(),po.getForks_count()));
//        System.out.println(dao.getPromisingScore_extern(po.getUpdated_at()));
        System.out.println(dao.getParticipationScore(po.getOpen_issues_count(),po.getForks_count()));


    }

    @Test
    public void getHotScore() throws Exception {

        String repo = "turingschool/curriculum";
        System.out.println(dao.getHotScore(repo));
        System.out.println(dao.getContributorsScore(repo));
        System.out.println(dao.getParticipationScore(repo));
        System.out.println(dao.getPromisingScore(repo));
        System.out.println(dao.getSizeScore(repo));
    }

    @Test
    public void getAllFullname() throws Exception {

        System.out.println(dao.getAllFullname());
    }

    @Test
    public void getSubscribionsOfUser() throws Exception {
        // System.out.println(dao.getSubscribionsOfUser("technoweenie"));
    }



    @Test
    public void test() {
        System.out.println(dao.getContributors("zhangzibin/char-rnn-chinese"));
    }

    @Test
    public void getSizeScore() throws Exception {
        System.out.println(dao.getSizeScore("jquery/jquery"));
    }


    @Test
    public void getContributorsScore_externTest() throws Exception {
        System.out.println(dao.getContributorsScore_extern(100));
    }

}