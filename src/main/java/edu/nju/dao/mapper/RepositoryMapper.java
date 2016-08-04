package edu.nju.dao.mapper;

import edu.nju.model.Repository;

public interface RepositoryMapper {
    int deleteByPrimaryKey(String full_name);

    int insert(Repository record);

    int insertSelective(Repository record);

    Repository selectByPrimaryKey(String full_name);

    int updateByPrimaryKeySelective(Repository record);

    int updateByPrimaryKeyWithBLOBs(Repository record);

    int updateByPrimaryKey(Repository record);
}