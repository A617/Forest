package edu.nju.data.dao;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by tj on 2016/5/3.
 */
public interface IRepoDao {

    int insert(Repository record);

    int insertContribute(String full_name, String login);

    int insertSubscribe(String full_name, String login);


    List<String> getAllFullname();

    /**
     * 获取所有项目
     *
     * @return
     */
    List<Repository> getAll();

    /**
     * 按照名称获取项目
     *
     * @param full_name
     * @return
     */
    Repository getReposByFullName(String full_name);

    List<String> getContributors_Extern(String full_name, String token) throws IOException;

    Repository getRepository_extern(String full_name, String token) throws IOException;

    String getRepoLanguages_extern(String full_name, String token) throws IOException;


    List<Repository> searchRepository(String name, String token, int page) throws IOException;


    /**
     * 获取使用每种语言的项目数目
     *
     * @return language, number
     */
    public Map<String, Integer> getLanguageStatistics();

    /**
     * 获取2007-2015创建项目的个数
     *
     * @return year, number
     */
    public Map<String, Integer> getCreatedTimeStatistics();

    /**
     * 获取一个项目每周的代码贡献量
     *
     * @param name
     * @return 从项目创建时间到即时的 week,number
     */
    public String getCodeFrequency(String name) throws IOException;

    String getCodeFrequency(String name, String token) throws IOException;


    List<String> enlargeViaSubscribers(String full_name, int limit);


    /**
     * 根据项目名，获得贡献者名单
     *
     * @param repo_fullname
     * @return
     */
    List<String> getContributors(String repo_fullname);


    /**
     * 根据项目名，获得和作者名单
     *
     * @param repo_fullname
     * @return
     */
    List<String> getCollaborators(String repo_fullname);

    double getHotScore(int stargazers_count, int forks_count);

    double getSizeScore(int size, String language);

    double getParticipationScore(int open_issues_count, int forks_count);


    /**
     * 获取贡献者度评分
     *
     * @return
     */
    double getContributorsScore_extern(int contributors);

    double getPromisingScore(String full_name, int stargazers_count, String token) throws IOException;

    /**
     * 获取HOT评分
     *
     * @return
     */
    double getHotScore(String full_name);

    /**
     * 获取大小评分
     *
     * @return
     */
    double getSizeScore(String full_name);

    /**
     * 获取参与度评分
     *
     * @return
     */
    double getParticipationScore(String fullname);

    /**
     * 获取期待度评分
     *
     * @return
     */
    double getPromisingScore(String full_name);

    /**
     * 获取贡献者度评分
     *
     * @return
     */
    double getContributorsScore(String full_name);

    /*
     *获得最新更新的三个项目
     */
    List<String> getLastUpdate_Three();

    /**
     * @param login
     * @return
     */
    String getReposDescription(String login);
}
