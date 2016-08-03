package edu.nju.service.impl;

import edu.nju.dao.RepositoryDao;
import edu.nju.service.RepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * Created by Dora on 2016/8/3.
 */
@Service
public class RepositoryServiceImpl implements RepositoryService {

    @Autowired
    RepositoryDao dao;

    @Override
    public edu.nju.model.Repository test() {
        return dao.selectByFullName("a");
    }
}
