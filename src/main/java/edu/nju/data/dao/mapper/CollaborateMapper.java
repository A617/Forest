package edu.nju.data.dao.mapper;

import edu.nju.data.model.Collaborate;
import org.apache.ibatis.annotations.Param;

public interface CollaborateMapper {
    int deleteByPrimaryKey(@Param("fullName") String fullName, @Param("login") String login);

    int insert(Collaborate record);

    int insertSelective(Collaborate record);
}