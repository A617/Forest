package edu.nju.dao;

import edu.nju.model.Repository;

/**
 * Created by Dora on 2016/8/3.
 */
@org.springframework.stereotype.Repository
public interface RepositoryDao {

    Repository selectByFullName(String full_name);
}
