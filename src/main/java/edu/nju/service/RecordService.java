package edu.nju.service;

import edu.nju.data.model.GraduateRecord;
import edu.nju.data.model.LevelUpRecord;
import edu.nju.data.model.MemberReport;
import edu.nju.data.model.ReportRecord;
import edu.nju.service.vo.RecordVO;

import java.util.List;

/**
 * Created by tjDu on 2016/9/11.
 */
public interface RecordService {
    /**
     * @param repoName
     * @return
     */
    List<MemberReport> getLearnRecordsOfRepo(String repoName);

    /**
     * @param userName
     * @return
     */
    List<MemberReport> getLearnRecordsOfUser(String userName);

    /**
     * @param roleName
     * @return
     */
    List<GraduateRecord> getGraduateRecordOfGoal(String roleName);

    /**
     * @param userName
     * @return
     */
    List<GraduateRecord> getGraduateRecordOfUser(String userName);

    /**
     * @param userName
     * @return
     */
    List<LevelUpRecord> getLevelUpRecordOfUser(String userName);

    /**
     * @param userName
     * @return
     */
    List<RecordVO> getUserRecords(String userName);

    /**
     * @param record
     * @return
     */
    int addReportRecord(MemberReport record);

    /**
     * @param record
     * @return
     */
    int addGraduateRecord(GraduateRecord record);

    /**
     * @param record
     * @return
     */
    int addLevelUpRecord(LevelUpRecord record);
}
