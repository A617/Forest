package edu.nju.service.impl;

import edu.nju.data.dao.IMemberDao;
import edu.nju.data.dao.IRepoDao;
import edu.nju.data.dao.IRoleDao;
import edu.nju.data.model.*;
import edu.nju.service.RecordService;
import edu.nju.service.vo.RecordCategory;
import edu.nju.service.vo.RecordVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by tjDu on 2016/9/11.
 */
@Service
public class RecordServiceImpl implements RecordService {
    @Resource
    private IMemberDao memberDao;
    @Resource
    private IRepoDao repoDao;
    @Resource
    private IRoleDao roleDao;

    @Override
    public List<MemberReport> getLearnRecordsOfRepo(String repoName) {
        return repoDao.getLearnRecordsOfRepo(repoName);
    }

    @Override
    public List<MemberReport> getLearnRecordsOfUser(String userName) {
        return memberDao.getLearnRecordsOfUser(userName);
    }

    @Override
    public List<GraduateRecord> getGraduateRecordOfGoal(String roleName) {
        return roleDao.getGraduateRecordOfGoal(roleName);
    }

    @Override
    public List<GraduateRecord> getGraduateRecordOfUser(String userName) {
        return memberDao.getGraduateRecordOfUser(userName);
    }

    @Override
    public List<LevelUpRecord> getLevelUpRecordOfUser(String userName) {
        return memberDao.getLevelUpRecordOfUser(userName);
    }

    @Override
    public List<RecordVO> getUserRecords(String userName) {
        List<RecordVO> result = new ArrayList<>();
        List<MemberReport> memberReports = getLearnRecordsOfUser(userName);
        for (MemberReport report : memberReports) {
            RecordVO vo = new RecordVO(report.getUsername(), report.getTime());
            vo.setCategory(RecordCategory.learn);
            result.add(vo);
        }
        List<GraduateRecord> graduateRecords = getGraduateRecordOfUser(userName);
        for (GraduateRecord report : graduateRecords) {
            RecordVO vo = new RecordVO(report.getUsername(), report.getTime());
            vo.setCategory(RecordCategory.graduate);
            result.add(vo);
        }
        List<LevelUpRecord> levelUpRecords = getLevelUpRecordOfUser(userName);
        for (LevelUpRecord report : levelUpRecords) {
            RecordVO vo = new RecordVO(report.getUsername(), report.getTime());
            vo.setCategory(RecordCategory.levelup);
            result.add(vo);
        }
        Collections.sort(result);
        return result;
    }

    @Override
    public int addReportRecord(MemberReport record) {
        return repoDao.reportRepository(record);
    }

    @Override
    public int addGraduateRecord(GraduateRecord record) {
        return roleDao.addGraduateRecordOfGoal(record);
    }

    @Override
    public int addLevelUpRecord(LevelUpRecord record) {
        Skill skill = new Skill();
        skill.setLevel(record.getLevel());
        skill.setName(record.getSkill_name());
        return memberDao.levelUp(skill, record.getUsername());
    }
}
