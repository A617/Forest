package edu.nju.data.dao.mapper;

import edu.nju.data.model.MemberReport;

public interface MemberReportMapper {
    int deleteByPrimaryKey(String username);

    int insert(MemberReport record);

    int insertSelective(MemberReport record);

    MemberReport selectByPrimaryKey(String username);

    int updateByPrimaryKeySelective(MemberReport record);

    int updateByPrimaryKey(MemberReport record);

    int updateEvaluateAndReason(MemberReport record );
}