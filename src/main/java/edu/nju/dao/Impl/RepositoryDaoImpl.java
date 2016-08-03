package edu.nju.dao.Impl;

import edu.nju.dao.RepositoryDao;
import edu.nju.dao.mapper.RepositoryMapper;
import edu.nju.model.Repository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Dora on 2016/8/3.
 */
@org.springframework.stereotype.Repository
public class RepositoryDaoImpl implements RepositoryDao {

    @Autowired
    RepositoryMapper mapper;

    @Override
    public Repository selectByFullName(String full_name) {
        return mapper.selectByFullName(full_name);
    }
}
