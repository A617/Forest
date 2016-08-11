package edu.nju.dao.mapper;

import edu.nju.model.User;

import java.sql.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public interface UserMapper {

    int insert(User record);

    int insertOwn(String login,String full_name);

    List<User> selectAll();

    User selectByLogin(String login);

    List<User> selectAllWithPager(Map<String,Object> params);

    List<User> searchUser(Map<String,Object> params);

    List<LinkedHashMap> countFirst30Companys();

    List<LinkedHashMap> countTypes();

    List<LinkedHashMap> countCreate_Year();

    List<User> selectUserByLanguage(Map<String,Object> params);

    List<User> selectUserByCompany(Map<String,Object> params);

    List<User> selectLan_Com(String language, String company, int pageSize, int pageOffset);

    int countLanguage(String language);

    int countCompany(String company);

    Integer countContribute(String login);

    List<String> selectContriRepo(String login);

    List<String> selectCollaRepo(String login);

    List<String> selectOwn(String login);

    List<String> selectEmail();

    List<LinkedHashMap> countEmail();

    int countBlog(String blog);

    List<Integer>countFollowers();

    List<Integer>countFollowings();

    int countFans(int first,int last);

    int countFollow(int first,int last);

    List<String> getUserLocation();

    List<String> selectLanguages();

    List<LinkedHashMap> selectLanguageByUser(String login);

    List<LinkedHashMap> selectNameLocation();

    List<LinkedHashMap> countFirst3Followers();

    List<LinkedHashMap> countFirst3Contributors();

    Integer selectRankOfExperience(String login,int contribute);

    Integer selectRankOfPopular(String login);

    Integer selectRankOfTeamwork(String full_name);

    Double getExperienceScore_Extern(int public_gists, int contributors);

    Double getPopularScore_Extern(int followers);

    int countAll();

    Integer countGist(String login);

    int countPopularScore_Extern(int sum);


    List<LinkedHashMap> countUserCreateMonth();

    List<LinkedHashMap> countOrgCreateMonth();

    List<String>selectLogin();

    int countContributors();

    List<String>selectContributors();

    Date getCreateTime(String login);
}