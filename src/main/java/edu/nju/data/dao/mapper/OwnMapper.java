package edu.nju.data.dao.mapper;

import edu.nju.data.model.OwnKey;

public interface OwnMapper {
    int deleteByPrimaryKey(OwnKey key);

    int insert(OwnKey record);

    int insertSelective(OwnKey record);
}