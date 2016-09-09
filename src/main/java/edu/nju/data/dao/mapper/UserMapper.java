package edu.nju.data.dao.mapper;

import edu.nju.data.model.User;
import org.springframework.stereotype.Component;

@Component
public interface UserMapper {
    int deleteByPrimaryKey(String login);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String login);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}