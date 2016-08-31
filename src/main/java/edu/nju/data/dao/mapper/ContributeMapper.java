package edu.nju.data.dao.mapper;

import edu.nju.data.model.Contribute;
import edu.nju.data.model.ContributeKey;

public interface ContributeMapper {
    int deleteByPrimaryKey(ContributeKey key);

    int insert(Contribute record);

    int insertSelective(Contribute record);

    Contribute selectByPrimaryKey(ContributeKey key);

    int updateByPrimaryKeySelective(Contribute record);

    int updateByPrimaryKey(Contribute record);
}