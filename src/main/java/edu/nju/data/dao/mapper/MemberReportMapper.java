package edu.nju.data.dao.mapper;

import edu.nju.data.model.MemberReport;
import edu.nju.data.model.ReportRecord;

import java.util.List;

public interface MemberReportMapper {
    int deleteByPrimaryKey(String username);

    int insert(MemberReport record);

    int insertSelective(MemberReport record);

    MemberReport selectByPrimaryKey(String username);

    int updateByPrimaryKeySelective(MemberReport record);

    int updateByPrimaryKey(MemberReport record);

    List<MemberReport> getLearnRecordsOfRepo(String repoName);

    List<MemberReport> getLearnRecordsOfUser(String userName);
}