package edu.nju.data.dao.mapper;

import edu.nju.data.model.Contribute;
import org.apache.ibatis.annotations.Param;

public interface ContributeMapper {
    int deleteByPrimaryKey(@Param("fullName") String fullName, @Param("login") String login);

    int insert(Contribute record);

    int insertSelective(Contribute record);

    Contribute selectByPrimaryKey(@Param("fullName") String fullName, @Param("login") String login);

    int updateByPrimaryKeySelective(Contribute record);

    int updateByPrimaryKey(Contribute record);
}