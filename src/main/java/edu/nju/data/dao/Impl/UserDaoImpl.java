package edu.nju.data.dao.Impl;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.nju.data.dao.UserDao;
import edu.nju.data.dao.mapper.RepositoryMapper;
import edu.nju.data.dao.mapper.UserMapper;
import edu.nju.data.model.*;
import edu.nju.data.task.HttpRequest;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.*;

/**
 * Created by phoebegl on 16/8/9.
 */
@org.springframework.stereotype.Repository
public class UserDaoImpl implements UserDao{

    @Resource
    UserMapper mapper;
    @Resource
    RepositoryMapper repomapper;

    @Override
    public List<User> selectAll() {
        return mapper.selectAll();
    }

    @Override
    public int insert(User user) {
        return mapper.insert(user);
    }

    @Override
    public int insertOwn(String login, String full_name) {
        return mapper.insertOwn(login, full_name);
    }

    @Override
    public User selectByLogin(String login) {
        return mapper.selectByLogin(login);
    }

    @Override
    public User getUser_Extern(String login, String token) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String s = HttpRequest.getGithubContentUsingHttpClient(token, "api.github.com/users/" + login);
        User user = mapper.readValue(s, User.class);
        return user;
    }

    @Override
    public Pager<User> selectAllWithPager() {
        Map<String, Object> map = createMap();

        List<User> data = mapper.selectAllWithPager(map);
        return createPage(data, map);
    }

    @Override
    public Pager<User> searchUser(String name) {
        Map<String, Object> map = createMap();
        map.put("name", name);
        List<User> data = mapper.searchUser(map);
        Pager<User> page = createPage(data, map);
        return page;
    }

    @Override
    public List<User> searchUser(String name, String token, int page) throws IOException{
        String s = HttpRequest.getGithubContentUsingHttpClient(token,"api.github.com/search/users?q="+name+"&sort=followers&per_page=10&page="+page);
        List<User> list = null;

        ObjectMapper mapper = new ObjectMapper();
        JsonFactory f = new JsonFactory();

        if (s!=null&&!s.equals("[]")) {
            s = mapper.readTree(s).get("items").toString();
            list = mapper.readValue(s,new TypeReference<List<User>>() {});
        }
        return list;
    }


    @Override
    public Pager<User> getUserByLanguage(String language) {
        Map<String, Object> map = createMap();
        map.put("language", language);
        List<User> data = mapper.selectUserByLanguage(map);
        Pager<User> page = createPage(data, map);
        return page;
    }

    @Override
    public Pager<User> getUserByCompany(String company) {
        Map<String, Object> map = createMap();
        map.put("company", company);
        List<User> data = mapper.selectUserByCompany(map);
        Pager<User> page = createPage(data, map);
        return page;
    }

    @Override
    public Pager<User> getUserByLan_Com(String language, String company) {
        String lan = language;
        String com = company;

        Map<String, Object> map = createMap();
        List<User> data = mapper.selectLan_Com(lan, com, (int) map.get("pageSize"), (int) map.get("pageOffset"));
        Pager<User> page = createPage(data, map);

        return page;
    }

    @Override
    public List<Day> getCommitCalendar(String login) {

        List<Day> result = new ArrayList<>();
        Document doc;
        try {
            doc = Jsoup.connect("https://github.com/" + login).get();

            Element calendar = doc.getElementById("contributions-calendar");
            Elements g = calendar.select("svg.js-calendar-graph-svg>g>g");


            for (Element e : g) {
                for (Element d : e.select("rect"))
                    result.add(new Day(Integer.parseInt(d.attr("data-count")), d.attr("data-date")));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;

    }


    @Override
    public List<String> getReposContributedViaWebpage(String login) {

        List<String> result = new ArrayList<>();
        Document doc;
        try {
            doc = Jsoup.connect("https://github.com/" + login).get();
            Elements e1 = doc.select(".mini-repo-list");
            if (e1 != null && e1.get(1) != null) {
                Elements e2 = e1.get(1).select("li a");
                for (Element e : e2) {
                    result.add(e.attr("href").substring(1));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;

    }

    @Override
    public List<String> getContriRepo(String login) {
        List<String> list = mapper.selectContriRepo(login);
        return list;
    }

    @Override
    public List<String> getContriRepo(String login, String token) throws IOException {
        String orgs = HttpRequest.getGithubContentUsingHttpClient(token,"api.github.com/users/"+login+"/orgs");
        List<String> orgList = parseJson2List(orgs,"login");

        List<String> result = new ArrayList<>();
        for(String org: orgList) {
            String s = HttpRequest.getGithubContentUsingHttpClient(token,"api.github.com/users/"+org+"/repos");
            List<String> list = parseJson2List(s,"full_name");
            if(list!=null) {
                result.addAll(list);
            }
        }
        return result;
    }
    @Override
    public List<String> getCollaRepo(String login) {
        List<String> list = mapper.selectCollaRepo(login);
        return list;
    }

    @Override
    public List<String> getCollaRepo(String login, String token) throws IOException {
        List<String> list = null;
//        String s = HttpRequest.getGithubContentUsingHttpClient(token, "api.github.com/users/" + login + "/repos?type=member");
//        list = parseJson2List(s,"full_name");
        return list;
    }

    private List<String> parseJson2List(String s, String key) throws IOException{
        List<String> list = new ArrayList<>();

        ObjectMapper mapper = new ObjectMapper();
        JsonFactory f = new JsonFactory();

        if (s!=null&&!s.equals("[]")) {

            JsonParser jp = f.createJsonParser(s);
            jp.nextToken();

            while (jp.nextToken() == JsonToken.START_OBJECT) {
                String full_name = (String) mapper.readValue(jp, Map.class).get(key);
                list.add(full_name);
            }
        }
        return list;
    }


    @Override
    public List<String> getOwn(String login) {
        List<String> list = mapper.selectOwn(login);
        return list;
    }

    @Override
    public List<LinkedHashMap> getLanguageSkills(String login) {
        List<LinkedHashMap> list = mapper.selectLanguageByUser(login);
        return list;
    }

    @Override
    public List<User> getAllChinaUser() {
        List<User> result = new ArrayList<>();
        List<LinkedHashMap> all = mapper.selectNameLocation();
        out:
        for (LinkedHashMap map : all) {
            String loc = (String) map.get("location");
            if (loc != null && !loc.isEmpty()) {
                loc.toLowerCase();
                for (int i = 0; i < Statistics.famousCity.length; i++) {
                    String temp = Statistics.EnglishCity[i];
                    if (loc.contains(temp)) {
                        User user = new User();
                        user.setLogin((String) map.get("login"));
                        user.setLocation(Statistics.famousCity[i]);
                        user.setHtml_url((String) map.get("html_url"));
                        result.add(user);
                        continue out;
                    }
                }
                for (int i = 0; i < Statistics.englishProvince.length; i++) {
                    String temp = Statistics.englishProvince[i];
                    if (loc.contains(temp)) {
                        User user = new User();
                        user.setLogin((String) map.get("login"));
                        user.setLocation(Statistics.province1[i]);
                        user.setHtml_url((String) map.get("html_url"));
                        result.add(user);
                        break;
                    }
                }
            }
        }
        return result;
    }

    @Override
    public List<LinkedHashMap> followersRank() {
        List<LinkedHashMap> list = mapper.countFirst3Followers();
        return list;
    }

    @Override
    public List<LinkedHashMap> contributeRank() {
        List<LinkedHashMap> list = mapper.countFirst3Contributors();
        return list;
    }

    @Override
    public double getExperienceScore(String login) {
        int num = 0;
        Integer numitg = mapper.countContribute(login);
        if (numitg != null)
            num = numitg.intValue();
        int sum = mapper.countAll();
        Integer itg = mapper.selectRankOfExperience(login, num);
        if (itg != null)
            return itg.doubleValue() / sum;
        else return 0;
    }

    @Override
    public double getPopularScore(String login) {
        int sum = mapper.countAll();
        Integer itg = mapper.selectRankOfPopular(login);
        if (itg != null)
            return itg.doubleValue() / sum;
        else return 0;
    }

    @Override
    public double getQualityScore(String login) {
        List<String> list = mapper.selectContriRepo(login);
        list.addAll(mapper.selectOwn(login));
        double hot_sum = 0.0;
//        int sum = repomapper.countAll();
//        Integer itg;
//        for (String repo : list) {
//            if ((itg = repomapper.selectRankOfHot(repo)) != null)
//                hot_sum += Math.sqrt(itg.doubleValue() / sum);
//        }
        double average = hot_sum / list.size();
        return average;
    }


    @Override
    public double getExperienceScore_Extern(int contributor, int gist) {
        Double score = mapper.getExperienceScore_Extern(gist, contributor);
        return score == null ? 0 : score;
    }

    @Override
    public double getPopularScore_Extern(int followers) {
        Double result = mapper.getPopularScore_Extern(followers);
        return result == null ? 0 : result;
    }

    private Map<String, Object> createMap() {
        Map<String, Object> map = new HashMap<String, Object>();
        int pageSize = SystemContext.getSize();
        int pageOffset = SystemContext.getOffset();
        map.put("pageSize", pageSize);
        map.put("pageOffset", pageOffset);
        return map;
    }

    private Pager<User> createPage(List<User> data, Map<String, Object> map) {
        Pager<User> pages = new Pager<User>(data, (int) map.get("pageOffset"),
                (int) map.get("pageSize"));
        return pages;
    }
}
