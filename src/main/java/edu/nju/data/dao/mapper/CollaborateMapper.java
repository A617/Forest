package edu.nju.data.dao.mapper;

import edu.nju.data.model.CollaborateKey;

public interface CollaborateMapper {
    int deleteByPrimaryKey(CollaborateKey key);

    int insert(CollaborateKey record);

    int insertSelective(CollaborateKey record);
}