package edu.nju.data.dao.mapper;

import edu.nju.data.model.GraduateRecord;
import org.apache.ibatis.annotations.Param;

public interface GraduateRecordMapper {
    int deleteByPrimaryKey(@Param("username") String username, @Param("role") String role);

    int insert(GraduateRecord record);

    int insertSelective(GraduateRecord record);

    GraduateRecord selectByPrimaryKey(@Param("username") String username, @Param("role") String role);

    int updateByPrimaryKeySelective(GraduateRecord record);

    int updateByPrimaryKey(GraduateRecord record);
}