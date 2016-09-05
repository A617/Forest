package edu.nju.data.dao.mapper;

import edu.nju.data.model.Repository;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.List;

@Component
public interface RepositoryMapper {
    int insert(Repository record);

    int insertContribute(String full_name,String login);

    int insertSubscribe(String full_name,String login);

    int insertCollaborate(String full_name,String login);

    int updateUpdatedAt(String full_name,Date date);

    Repository selectByFullName(String full_name);

    List<String> selectFullName();

    List<Repository> selectAll();

}