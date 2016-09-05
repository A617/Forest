package edu.nju.data.dao.mapper;

import edu.nju.data.model.Repository;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Component
public interface RepositoryMapper {
    int insert(Repository record);

    int insertContribute(String full_name,String login);

    int insertSubscribe(String full_name,String login);

    int insertCollaborate(String full_name,String login);

    int updateUpdatedAt(String full_name,Date date);

    List<Repository> selectAll();

    List<String> selectFullName();

    Repository selectByFullName(String full_name);

    List<Repository> searchRepository(Map<String, Object> map);

    List<Repository> selectReposSortedByFork(Map<String, Object> map);

    List<Repository> selectReposSortedByStar(Map<String, Object> map);

    List<Repository> selectReposSortedByContribute(Map<String, Object> map);

    List<Repository> selectAllPaged(Map<String, Object> map);

    List<Repository> selectReposByYear(Map<String, Object> map);

    List<Repository> selectReposByLanguage(Map<String, Object> map);

    List<Repository> selectReposByKey(Map<String, Object> map);


    List<Repository> selectReposByLan_Key_Year(String language, String keyword, String year, @Param(value = "sort") String sort, int pageSize, int pageOffset);

    List<Repository> selectReposByLan_Key_YearSortByContri(String language,String keyword,String year,int pageSize,int pageOffset);

    int countAll();

    int countSearch(String fullName);

    int countYear(int year);

    int countLanguage(String language);

    int countKey(String keyword);

    int countLan_Key_Year(String language, String keyword, String year);

    List<LinkedHashMap> countFirst20Languages();

    Integer countLanguagesCreated(String year, String name);

    List<LinkedHashMap> getLanguageAndSize();

    List<LinkedHashMap> countCreatedYear();

    List<String> getContributors(String full_name);

    List<String> getSubscribers(String full_name);

    List<String> getSubscribionsOfUser(String login);

    List<String> getCollaborators(String repo_fullname);

    List<String> countFirst10Languages();

    List<Integer> countForks();

    List<Integer> countSubscribers();

    List<Integer> countStars();

    List<String> getYear();

    List<String> eachYear();

    List<Integer> eachSize();

    List<LinkedHashMap> countAverageSize_year();

    List<Integer>getSizeByLan(String language);

    List<Integer>getForksByLan(String language);

    List<String> selectLanguages();
    //hot: star+fork+watch
    // participation: issue + fork*3
    //size:size group by language
    // contributors:contributors
    // promising: updated_at


    Integer selectRankOfHot(String full_name);

    Integer selectRankOfSize(String full_name);

    Integer selectRankOfParticipation(String full_name);

    Integer selectRankOfPromising(String full_name);

    Integer selectRankOfContributors(String full_name);

    List<String> enlargeViaSubscribers(String full_name, int limit);

    String getLan_SingleRepo(String full_name);

    List<Repository> getStarLarger(int balance);

    List<Repository> getStarFewer(int balance);

    List<Repository> getForkLarger(int balance);

    List<Repository> getForkFewer(int balance);

    List<Repository> getContributeLarger(int balance);

    List<Repository> getContributeFewer(int balance);

    List<String> getLastUpdate_Three();

    Double selectHotScore_Extern(int stargazers_count, int forks_count);

    Double selectParticipationScore_Extern(int open_issues_count, int forks_count);

    Integer countPromisingScore_Extern(Date date);

    Double selectSizeScore_Extern(int size,String language);

    List<Integer> countContributors();

    List<LinkedHashMap> countCreateMonth();

    String getReposDescription(String login);
}