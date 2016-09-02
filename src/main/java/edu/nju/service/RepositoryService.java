package edu.nju.service;

/**
 * Created by Dora on 2016/8/3.
 */
public interface RepositoryService {
    /**
     * 用户点击学习仓库
     *
     * @param userName
     * @param reposName
     */
    void learnRepository(String userName, String reposName);

    /**
     * 用户反馈
     *
     * @param report
     */
    void reportRepository(MemberReport report);
}
