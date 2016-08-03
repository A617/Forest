package edu.nju.dao.mapper;

import edu.nju.model.Repository;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public interface RepositoryMapper {

    @Select("select * from repository where full_name='a'")
    Repository selectByFullName(String full_name);

}