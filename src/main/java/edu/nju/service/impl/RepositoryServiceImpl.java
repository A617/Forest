package edu.nju.service.impl;

import edu.nju.dao.RepositoryDao;
import edu.nju.service.RepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Dora on 2016/8/3.
 */
@Service
public class RepositoryServiceImpl implements RepositoryService {

    @Resource
    private RepositoryDao repository;

    @Override
    public Repository test() {

        return dao.selectByFullName("a");
    }
}
