package edu.nju.service.impl;

import edu.nju.data.dao.IRepoDao;
import edu.nju.data.model.MemberReport;
import edu.nju.data.model.Repository;
import edu.nju.service.RepositoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.validation.constraints.AssertFalse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Dora on 2016/8/3.
 */
@Service
public class RepositoryServiceImpl implements RepositoryService {
    @Resource
    IRepoDao repoDao;

    @Override
    public int learnRepository(String userName, String reposName) {
        return repoDao.learnRepository(userName, reposName);
    }

    @Override
    public int reportRepository(MemberReport report) {
        return repoDao.reportRepository(report);
    }

    @Override
    public Repository showRepository(String fullname) {
        return repoDao.getReposByFullName(fullname);
    }

    @Override
    public List<Repository> showHotRepos(){
        return repoDao.getAll();
    }

    @Override
    public String getCodeFrequency(String full_name,String token) {
        try {
            return repoDao.getCodeFrequency(full_name,token);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
