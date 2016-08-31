package edu.nju.data.dao.mapper;

import edu.nju.data.model.Subscribe;
import org.apache.ibatis.annotations.Param;

public interface SubscribeMapper {
    int deleteByPrimaryKey(@Param("fullName") String fullName, @Param("login") String login);

    int insert(Subscribe record);

    int insertSelective(Subscribe record);
}