package edu.nju.data.impl;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.nju.data.dao.IRepoDao;
import edu.nju.data.dao.mapper.MemberReportMapper;
import edu.nju.data.dao.mapper.RepositoryMapper;
import edu.nju.data.model.MemberReport;
import edu.nju.data.model.Repository;
import edu.nju.data.task.HttpRequest;

import javax.annotation.Resource;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

/**
 * Created by fwtgm on 2016/9/4.
 */
@org.springframework.stereotype.Repository("repoDao")
public class RepoDaoImpl implements IRepoDao {
    @Resource
    private RepositoryMapper mapper;
    @Resource
    private MemberReportMapper mapper2;

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
        JsonFactory f = new JsonFactory();
        ObjectMapper mapper = new ObjectMapper();

        List<String> result = new ArrayList<>();

        String contri = HttpRequest.getGithubContentUsingHttpClient(token, "api.github.com/repos/" + full_name + "/contributors");
        JsonParser jp = f.createJsonParser(contri);
        jp.nextToken();

        result = new ArrayList<String>();

        while (jp.nextToken() == JsonToken.START_OBJECT) {

            String login = (String) mapper.readValue(jp, Map.class).get("login");

            result.add(login);
        }
        return result;
    }

    @Override
    public Repository getRepository_extern(String full_name, String token) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        Repository repo = null;

        String s = HttpRequest.getGithubContentUsingHttpClient(token, "api.github.com/repos/" + full_name);
        repo = mapper.readValue(s, Repository.class);
        repo.setOwner_name(repo.getFull_name().split("/")[0]);
        if (repo.getLanguage() == null)
            repo.setLanguage("");

        return repo;
    }

    @Override
    public String getRepoLanguages_extern(String full_name, String token) throws IOException {
        String lan = null;
        lan = HttpRequest.getGithubContentUsingHttpClient("api.github.com/repos/" + full_name + "/languages");

        return lan;
    }

    @Override
    public List<Repository> searchRepository(String name, String token, int page) throws IOException {
        String s = HttpRequest.getGithubContentUsingHttpClient(token, "api.github.com/search/repositories?q=" + name + "&sort=stars&per_page=10&page=" + page);
        List<Repository> list = null;

        ObjectMapper mapper = new ObjectMapper();
        JsonFactory f = new JsonFactory();

        if (s != null && !s.equals("[]")) {
            s = mapper.readTree(s).get("items").toString();
            list = mapper.readValue(s, new TypeReference<List<Repository>>() {
            });
        }
        return list;
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
        String url = "api.github.com/repos/" + name + "/stats/code_frequency";
        return HttpRequest.getGithubContentUsingHttpClient(url);
    }

    @Override
    public String getCodeFrequency(String name, String token) throws IOException {
        String url = "api.github.com/repos/" + name + "/stats/code_frequency";
        return HttpRequest.getGithubContentUsingHttpClient(token, url);
    }

    @Override
    public List<String> enlargeViaSubscribers(String full_name, int limit) {
        List<String> list = mapper.enlargeViaSubscribers(full_name, limit);
        return list;
    }

    @Override
    public List<String> getContributors(String repo_fullname) {
        List<String> list = mapper.getContributors(repo_fullname);
        return list;
    }

    @Override
    public List<String> getCollaborators(String repo_fullname) {
        List<String> list = mapper.getCollaborators(repo_fullname);
        return list;
    }

    @Override
    public double getHotScore(int stargazers_count, int forks_count) {
        Double d = mapper.selectHotScore_Extern(stargazers_count, forks_count);
        return d == null ? 0 : d;
    }

    @Override
    public double getSizeScore(int size, String language) {
        Double d = mapper.selectSizeScore_Extern(size, language);
        double result = d == null ? 0.5 : d;
        return result;
    }

    @Override
    public double getParticipationScore(int open_issues_count, int forks_count) {
        Double d = mapper.selectParticipationScore_Extern(forks_count, open_issues_count);
        return d == null ? 0 : d;
    }

    @Override
    public double getContributorsScore_extern(int contributors) {
        List<Integer> list = mapper.countContributors();
        int count = 0;
        for (int i : list) {
            if (i < contributors) {
                count++;
            }
        }
        double result = (double) count / list.size();
        return result;
    }

    @Override
    public double getPromisingScore(String full_name, int stargazers_count, String token) throws IOException {
        int page = stargazers_count / 30 + 1;
        int count = 0;
        Calendar date = Calendar.getInstance();
        date.set(Calendar.MONTH, date.get(Calendar.MONTH) - 1);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss'Z'");

        ObjectMapper mapper = new ObjectMapper();
        JsonFactory f = new JsonFactory();
        boolean flag = false;

        int j = 0;
        while (!flag && page >= 1 && j < 2) {
            String s = HttpRequest.getStarJson("api.github.com/repos/" + full_name + "/stargazers?page=" + page, token);
            if (s.equals("[]")) break;
            JsonParser jp = f.createJsonParser(s);
            jp.nextToken();

            int i = 0;
            while (jp.nextToken() == JsonToken.START_OBJECT) {
                String starred_at = (String) mapper.readValue(jp, Map.class).get("starred_at");
                if (starred_at.compareTo(sdf.format(date.getTime()).toString()) < 0) {
                    i++;
                    flag = true;
                } else {
                    break;
                }
            }
            count += (j == 0 ? stargazers_count % 30 : 30) - i;
            page--;
            j++;
        }
        return count > 30 ? 1 : count / 30.0;
    }

    @Override
    public double getHotScore(String full_name) {
        int sum = mapper.countAll();
        Integer rk = mapper.selectRankOfHot(full_name);
        double result = 0;
        if (rk != null)
            result = rk.doubleValue() / sum;
        return result;
    }

    @Override
    public double getSizeScore(String full_name) {
        String lan = mapper.getLan_SingleRepo(full_name);
        int sum = mapper.countLanguage(lan);
        Integer rk = mapper.selectRankOfSize(full_name);
        double result = 0;
        if (rk != null)
            result = rk.doubleValue() / sum;
        return result;
    }

    @Override
    public double getParticipationScore(String full_name) {
        int sum = mapper.countAll();
        Integer rk = mapper.selectRankOfParticipation(full_name);
        double result = 0;
        if (rk != null)
            result = rk.doubleValue() / sum;
        return result;
    }

    @Override
    public double getPromisingScore(String full_name) {
        int sum = mapper.countAll();
        Integer rk = mapper.selectRankOfPromising(full_name);
        double result = 0;
        if (rk != null)
            result = rk.doubleValue() / sum;
        return result;
    }

    @Override
    public double getContributorsScore(String full_name) {
        Integer rk = mapper.selectRankOfContributors(full_name);
        double result = 0;
        if (rk != null)
            result = rk.doubleValue();
        return result;
    }

    @Override
    public List<String> getLastUpdate_Three() {
        List<String> list = mapper.getLastUpdate_Three();
        return list;
    }

    @Override
    public String getReposDescription(String login) {
        return mapper.getReposDescription(login);
    }

    @Override
    public int learnRepository(String userName, String reposName) {
        java.sql.Date date;
        date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        MemberReport mr = new MemberReport(userName, reposName, 0, "a", date);
        return mapper2.insert(mr);
    }

    @Override
    public int reportRepository(MemberReport report) {

        return mapper2.updateEvaluateAndReason(report);
    }


}
