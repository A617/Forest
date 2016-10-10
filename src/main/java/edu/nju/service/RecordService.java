package edu.nju.service;

import edu.nju.data.model.*;
import edu.nju.service.vo.GraduateRecordVO;
import edu.nju.service.vo.LearnRecordVO;
import edu.nju.service.vo.LevelUpRecordVO;
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
    List<LearnRecordVO> getLearnRecordsOfRepo(String repoName);

    /**
     * @param userName
     * @return
     */
    List<LearnRecordVO> getLearnRecordsOfUser(String userName);

    /**
     * @param roleName
     * @return
     */
    List<GraduateRecordVO> getGraduateRecordOfGoal(String roleName);

    /**
     * @param userName
     * @return
     */
    List<GraduateRecordVO> getGraduateRecordOfUser(String userName);

    /**
     * @param userName
     * @return
     */
    List<LevelUpRecordVO> getLevelUpRecordOfUser(String userName);

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

    public List<LearnCounts> getLearnCountsEveryday(String username);
}
