package edu.nju.data.dao;

import edu.nju.data.model.*;

import java.util.List;

/**
 * Created by tjDu on 2016/9/8.
 */
public interface IMemberDao {
    /**
     * 搜member信息
     * @return
     */
    Member showMember(String username);

    /**
     * 增加member
     * @param member
     * @return
     */
    boolean addMember(Member member);

    /**
     * 升级角色中的某项技能
     *
     * @param skill
     * @param userName
     */
    int levelUp(Skill skill, String userName);

    List<String> getLearnedRepos(String username);

    List<LevelUpRecord> getLevelUpRecordOfUser(String userName);

    List<GraduateRecord> getGraduateRecordOfUser(String userName);

    List<MemberReport> getLearnRecordsOfUser(String userName);

    List<LearnCounts> getLearnCountsEveryday(String username);

}
