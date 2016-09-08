package edu.nju.service;

import edu.nju.data.model.MemberReport;
import edu.nju.data.model.Repository;

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
    int learnRepository(String userName, String reposName);

    /**
     * 用户反馈
     *
     * @param report
     */
    int reportRepository(MemberReport report);

    Repository showRepository(String fullname);
}
