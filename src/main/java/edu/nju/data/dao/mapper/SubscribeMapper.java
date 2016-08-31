package edu.nju.data.dao.mapper;

import edu.nju.data.model.SubscribeKey;

public interface SubscribeMapper {
    int deleteByPrimaryKey(SubscribeKey key);

    int insert(SubscribeKey record);

    int insertSelective(SubscribeKey record);
}