package edu.nju.dao;

import edu.nju.model.Day;
import edu.nju.model.Pager;
import edu.nju.model.User;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by phoebegl on 16/8/9.
 */
public interface UserDao {
    List<User> selectAll();

    int insert(User user);

    int insertOwn(String login, String full_name);

    /**
     * 查找一个用户
     * @param login
     * @return
     */
    User selectByLogin(String login);

    User getUser_Extern(String login, String token) throws IOException;

    /**
     * 分页查看所有用户
     * @return
     */
    Pager<User> selectAllWithPager();

    /**
     * 模糊搜索用户
     * @param name
     * @return
     */
    Pager<User> searchUser(String name);

    // int countAll();

    List<User> searchUser(String name, String token, int page) throws IOException;

    /**
     * 根据语言筛选用户
     * @param language
     * @return
     */
    Pager<User> getUserByLanguage(String language);

    /**
     * 根据公司筛选用户
     * @param company
     * @return
     */
    Pager<User> getUserByCompany(String company);


    /**
     * 根据语言和公司筛选用户
     * @param language,company
     * @return
     */

    Pager<User> getUserByLan_Com(String language, String company);

    List<Day> getCommitCalendar(String login);

    List<String> getReposContributedViaWebpage(String login);

    /**
     * 根据用户名筛选贡献过的项目
     * @param login
     * @return
     */
    List<String> getContriRepo(String login);

    List<String> getContriRepo(String login, String token) throws IOException;

    /**
     * 根据用户名筛选合作过的项目
     * @param login
     * @return
     */
    List<String> getCollaRepo(String login);

    List<String> getCollaRepo(String full_name, String token) throws IOException;

    /**
     * 根据用户名筛选创建过的项目
     * @param login
     * @return
     */
    List<String> getOwn(String login);

    /**
     * value:count, name:language
     * @param login
     * @return 用户掌握的语言分析
     */
    List<LinkedHashMap> getLanguageSkills(String login);

    /**
     *
     * @return 所有中国的用户
     */
    List<User> getAllChinaUser();

    /**
     * @return 前三名的粉丝最多的用户及粉丝数
     */
    List<LinkedHashMap> followersRank();

    /**
     * @return 前三名的贡献过的项目最多的用户及贡献项目个数
     */
    List<LinkedHashMap> contributeRank();
    /**
     * 获取经验值评分：5*contributed + gist
     * @return
     */
    double getExperienceScore(String login);
    /**
     * 获取粉丝度评分 follower
     * @return
     */
    double getPopularScore(String login);
    /**
     * 获取质量评分 contributed项目hotscore的均值
     * @return
     */
    double getQualityScore(String login);
    /**
     * 获取合作度评分 contributed项目的collaborator数目 和创建项目的collaborator数目
     * @return
     */
//    double getTeamworkScore(String login);

    /**
     * 获取经验值评分：5*contributed + gist
     * @return
     */
    double getExperienceScore_Extern(int contributor,int gist);
    /**
     * 获取粉丝度评分 follower
     * @return
     */
    double getPopularScore_Extern(int followers);
}
