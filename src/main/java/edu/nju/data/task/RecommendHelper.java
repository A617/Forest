package edu.nju.data.task;

import edu.nju.data.Impl.RepoDaoImpl;
import edu.nju.data.Impl.SkillDaoImpl;
import edu.nju.data.model.SimpleRepo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.*;

/**
 * Created by tjDu on 2016/9/10.
 */
public class RecommendHelper {
    private RepoDaoImpl repoDao;
    private SkillDaoImpl skillDao;
    private List<String> filterList;
    private Set<String> users;
    private List<String> skills;
    private final String protoRepos ="dypsilon/frontend-dev-bookmarks";
    /**
     * key-repository,value:map(key-username,value:score)
     */
    private Map<String, Map<String, Double>> prefers;

    public RecommendHelper() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-mybatis.xml");
        repoDao = (RepoDaoImpl) context.getBean("repoDao");
        filterList = new ArrayList<>();
        users = new HashSet<>();
        prefers = new HashMap<>();
        filter("html");
        initPrefers();
        System.out.println(topMatches(3, protoRepos));
    }


    /**
     * 过滤出与该技能有关的项目
     */
    public void filter(String skillName) {
        List<SimpleRepo> list = repoDao.getAllSimpleRepo();
        for (SimpleRepo repo : list) {
            String name = repo.getFull_name().toLowerCase();
            String description = repo.getFull_name().toLowerCase();
            String language = repo.getLanguage().toLowerCase();
            if (name.contains(skillName) || description.contains(skillName) ||
                    language.contains(skillName)) {
                filterList.add(repo.getFull_name());
                if (filterList.size() > 1000) {
                    return;
                }
            }
        }
        if (!filterList.contains(protoRepos)) {
            filterList.add(protoRepos);
        }
    }

    /**
     * 初始化偏好值
     */
    public void initPrefers() {
        //先把所有有关的user放在一个集合里
        for (String repoName : filterList) {
            List<String> watchers = repoDao.getWatchers(repoName);
            users.addAll(watchers);
        }

        for (String repo : filterList) {
            List<String> watchers = repoDao.getWatchers(repo);
            Map<String, Double> scoreMap = new HashMap<>();
            for (String user : users) {
                if (watchers.contains(user)) {
                    scoreMap.put(user, 1.0);
                } else {
                    scoreMap.put(user, 0.0);
                }
            }
            prefers.put(repo, scoreMap);
        }
    }

    public double sim_pearson(String repo1, String repo2) {
        double sum1;
        double sum2;
        double sum1Sq = 0.0;
        double sum2Sq = 0.0;
        double pSum = 0.0;
        Map<String, Double> scores1 = prefers.get(repo1);
        sum1 = getSum(scores1);
        //因为value都是1 所以平方和还是1
        sum1Sq = sum1;
        Map<String, Double> scores2 = prefers.get(repo2);
        sum2 = getSum(scores2);
        sum2Sq = sum2;

        //求乘积之和
        for (String repo : scores1.keySet()) {
            pSum += scores1.get(repo) * scores2.get(repo);
        }
        //计算皮尔逊评价值
        int n = scores1.size();
        double num = pSum - (sum1 * sum2 / n);
        double den = Math.sqrt((sum1Sq - Math.pow(sum1, 2) / n) * (sum2Sq - Math.pow(sum2, 2) / n));
        if (den == 0) {
            return 0;
        } else {
            return num / den;
        }
    }

    public List<String> topMatches(int n, String repoName) {
        List<String> matchRepos = new ArrayList<>();
        List<RepoScore> scores = new ArrayList<>();
        Collection<String> set = prefers.keySet();
        for (String other : set) {
            if (other.equals(repoName)) {
                continue;
            }
            double d = sim_pearson(repoName, other);
            RepoScore repoScore = new RepoScore();
            repoScore.score = d;
            repoScore.name = other;
            scores.add(repoScore);
        }
        Collections.sort(scores);
        for (int i = 0; i < n; i++) {
            matchRepos.add(scores.get(i).name);
        }
        return matchRepos;
    }

    private double getSum(Map<String, Double> scores) {
        Collection<Double> values = scores.values();
        double sum = 0.0;
        for (Double d : values) {
            sum += d;
        }
        return sum;
    }

    public static void main(String[] args) {
        RecommendHelper helper = new RecommendHelper();

    }

    public class RepoScore implements Comparable<RepoScore> {
        public String name;
        public double score;


        @Override
        public int compareTo(RepoScore o) {
            return (int) (this.score - o.score);
        }
    }
}
