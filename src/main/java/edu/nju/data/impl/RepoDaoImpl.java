package edu.nju.data.impl;

import edu.nju.data.dao.IRepoDao;
import edu.nju.data.dao.mapper.RepositoryMapper;
import edu.nju.data.model.MemberReport;
import edu.nju.data.model.Repository;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by fwtgm on 2016/9/4.
 */
@org.springframework.stereotype.Repository("repoDao")
public class RepoDaoImpl implements IRepoDao{
    @Resource
    private RepositoryMapper mapper;
    String[] searchMethod = {"getStarFewer", "getStarLarger", "getForkFewer", "getForkLarger", "getContributeFewer", "getContributeLarger"};

    @Override
    public int insert(Repository record) {
        return mapper.insert(record);
    }

    @Override
    public int insertContribute(String full_name, String login) {
        return mapper.insertContribute(full_name, login);
    }

    @Override
    public int insertSubscribe(String full_name, String login) {
        return mapper.insertSubscribe(full_name, login);
    }

    @Override
    public List<String> getAllFullname() {
        return mapper.selectFullName();
    }

    @Override
    public List<Repository> getAll() {
        return mapper.selectAll();
    }

    @Override
    public Repository getReposByFullName(String full_name) {
        return mapper.selectByFullName(full_name);
    }

    @Override
    public List<String> getContributors_Extern(String full_name, String token) throws IOException {
        return null;
    }

    @Override
    public Repository getRepository_extern(String full_name, String token) throws IOException {
        return null;
    }

    @Override
    public String getRepoLanguages_extern(String full_name, String token) throws IOException {
        return null;
    }

    @Override
    public List<Repository> searchRepository(String name, String token, int page) throws IOException {
        return null;
    }

    @Override
    public Map<String, Integer> getLanguageStatistics() {
        return null;
    }

    @Override
    public Map<String, Integer> getCreatedTimeStatistics() {
        return null;
    }

    @Override
    public String getCodeFrequency(String name) throws IOException {
        return null;
    }

    @Override
    public String getCodeFrequency(String name, String token) throws IOException {
        return null;
    }

    @Override
    public List<String> enlargeViaSubscribers(String full_name, int limit) {
        return null;
    }

    @Override
    public List<String> getContributors(String repo_fullname) {
        return null;
    }

    @Override
    public List<String> getCollaborators(String repo_fullname) {
        return null;
    }

    @Override
    public double getHotScore(int stargazers_count, int forks_count) {
        return 0;
    }

    @Override
    public double getSizeScore(int size, String language) {
        return 0;
    }

    @Override
    public double getParticipationScore(int open_issues_count, int forks_count) {
        return 0;
    }

    @Override
    public double getContributorsScore_extern(int contributors) {
        return 0;
    }

    @Override
    public double getPromisingScore(String full_name, int stargazers_count, String token) throws IOException {
        return 0;
    }

    @Override
    public double getHotScore(String full_name) {
        return 0;
    }

    @Override
    public double getSizeScore(String full_name) {
        return 0;
    }

    @Override
    public double getParticipationScore(String fullname) {
        return 0;
    }

    @Override
    public double getPromisingScore(String full_name) {
        return 0;
    }

    @Override
    public double getContributorsScore(String full_name) {
        return 0;
    }

    @Override
    public List<String> getLastUpdate_Three() {
        return null;
    }

    @Override
    public String getReposDescription(String login) {
        return null;
    }

    @Override
    public void learnRepository(String userName, String reposName) {

    }

    @Override
    public void reportRepository(MemberReport report) {

    }


}
