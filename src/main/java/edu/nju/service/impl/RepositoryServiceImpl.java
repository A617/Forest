package edu.nju.service.impl;

import edu.nju.data.dao.IRepoDao;
import edu.nju.data.model.MemberReport;
import edu.nju.service.RepositoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Dora on 2016/8/3.
 */
@Service
public class RepositoryServiceImpl implements RepositoryService {
    @Resource
    IRepoDao repoDao;
    @Override
    public void learnRepository(String userName, String reposName) {

    }

    @Override
    public void reportRepository(MemberReport report) {

    }
}
