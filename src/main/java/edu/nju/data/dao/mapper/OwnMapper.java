package edu.nju.data.dao.mapper;

import edu.nju.data.model.Own;
import org.apache.ibatis.annotations.Param;

public interface OwnMapper {
    int deleteByPrimaryKey(@Param("fullName") String fullName, @Param("login") String login);

    int insert(Own record);

    int insertSelective(Own record);
}