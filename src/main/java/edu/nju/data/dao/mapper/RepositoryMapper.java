package edu.nju.data.dao.mapper;

import edu.nju.data.model.Repository;
import edu.nju.data.model.SimpleRepo;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public interface RepositoryMapper {
    int insert(Repository record);

    int insertContribute(String full_name,String login);

    int insertSubscribe(String full_name,String login);

    int insertCollaborate(String full_name,String login);

    int updateUpdatedAt(String full_name,Date date);

    Repository selectByFullName(String full_name);

    List<String> selectFullName();

    List<Repository> selectAll();

    List<String> enlargeViaSubscribers(String full_name, int limit);

    List<String> getContributors(String full_name);

    List<String> getCollaborators(String repo_fullname);

    Double selectHotScore_Extern(int stargazers_count, int forks_count);

    Double selectParticipationScore_Extern(int open_issues_count, int forks_count);

    Double selectSizeScore_Extern(int size,String language);

    List<Integer> countContributors();

    Integer countAll();

    Integer selectRankOfHot(String full_name);

    String getLan_SingleRepo(String full_name);

    int countLanguage(String language);

    Integer selectRankOfSize(String full_name);

    Integer selectRankOfParticipation(String full_name);

    Integer selectRankOfPromising(String full_name);

    Integer selectRankOfContributors(String full_name);

    List<String> getLastUpdate_Three();

    String getReposDescription(String login);

    String getRepoUrl(String name);

    List<SimpleRepo> getAllSimpleRepo();
}