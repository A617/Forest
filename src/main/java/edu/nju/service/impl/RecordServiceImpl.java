package edu.nju.service.impl;

import edu.nju.data.dao.IMemberDao;
import edu.nju.data.dao.IRepoDao;
import edu.nju.data.dao.IRoleDao;
import edu.nju.data.model.*;
import edu.nju.service.RecordService;
import edu.nju.service.vo.*;
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
    public List<LearnRecordVO> getLearnRecordsOfRepo(String repoName) {
        List<LearnRecordVO> result = new ArrayList<>();
        List<MemberReport> datas = repoDao.getLearnRecordsOfRepo(repoName);
        for (MemberReport report : datas) {
            LearnRecordVO vo = generateLearn(report);
            result.add(vo);
        }
        return result;
    }


    @Override
    public List<LearnRecordVO> getLearnRecordsOfUser(String userName) {
        List<LearnRecordVO> result = new ArrayList<>();
        List<MemberReport> datas = memberDao.getLearnRecordsOfUser(userName);
        for (MemberReport report : datas) {
            LearnRecordVO vo = generateLearn(report);
            result.add(vo);
        }
        return result;
    }

    @Override
    public List<GraduateRecordVO> getGraduateRecordOfGoal(String roleName) {
        List<GraduateRecordVO> result = new ArrayList<>();
        for (GraduateRecord record : roleDao.getGraduateRecordOfGoal(roleName)) {
            GraduateRecordVO vo = generateGraduate(record);
            result.add(vo);
        }
        return result;
    }

    @Override
    public List<GraduateRecordVO> getGraduateRecordOfUser(String userName) {
        List<GraduateRecordVO> result = new ArrayList<>();
        for (GraduateRecord record : memberDao.getGraduateRecordOfUser(userName)) {
            GraduateRecordVO vo = generateGraduate(record);
            result.add(vo);
        }
        return result;
    }

    @Override
    public List<LevelUpRecordVO> getLevelUpRecordOfUser(String userName) {
        List<LevelUpRecordVO> result = new ArrayList<>();
        for (LevelUpRecord record : memberDao.getLevelUpRecordOfUser(userName)) {
            LevelUpRecordVO vo = generateLevelup(record);
            result.add(vo);
        }
        return result;
    }

    @Override
    public List<RecordVO> getUserRecords(String userName) {
        List<RecordVO> result = new ArrayList<>();
        List<LearnRecordVO> memberReports = getLearnRecordsOfUser(userName);
        List<GraduateRecordVO> graduateRecords = getGraduateRecordOfUser(userName);
        List<LevelUpRecordVO> levelUpRecords = getLevelUpRecordOfUser(userName);
        result.addAll(memberReports);
        result.addAll(graduateRecords);
        result.addAll(levelUpRecords);
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

    private LearnRecordVO generateLearn(MemberReport report) {
        String name = report.getFullName();
        int id = memberDao.showMember(report.getUsername()).getId();
        Repository repos = repoDao.getReposByFullName(name);
        return new LearnRecordVO(report.getUsername(), id, repos, report.getTime());
    }

    private GraduateRecordVO generateGraduate(GraduateRecord report) {
        String roleName = report.getRole();
        Role role = roleDao.selectRoleByName(roleName);
        return new GraduateRecordVO(report.getUsername(), role, report.getTime());
    }

    private LevelUpRecordVO generateLevelup(LevelUpRecord report) {
        Skill skill = new Skill(report.getSkill_name(), report.getLevel());
        return new LevelUpRecordVO(report.getUsername(), skill, report.getTime());
    }
}
