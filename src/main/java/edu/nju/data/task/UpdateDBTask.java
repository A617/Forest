package edu.nju.data.task;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import edu.nju.data.dao.mapper.RepositoryMapper;
import edu.nju.data.dao.mapper.UserMapper;
import edu.nju.data.model.Repository;
import edu.nju.data.model.User;
import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.zip.GZIPInputStream;

/**
 * Created by Dora on 2016/5/17.
 * 每天定时执行，分析两天前的8小时内fork数目最大且总（star+fork）数>=30
 * 的项目及其相关联的用户加入数据库。
 */
@Component("taskJob")
public class UpdateDBTask {
    private static final Logger LOG = Logger.getLogger(UpdateDBTask.class);

    @Resource
    RepositoryMapper dao;
    @Resource
    UserMapper userdao;

    //                秒 分 时 天 月
    @Scheduled(cron = "0 24 * * * ?")
    public void job() {
        System.out.println("task starts");
        Calendar date = Calendar.getInstance();
        date.set(Calendar.DATE, date.get(Calendar.DATE) - 1);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dt = new Date();
        try {
            dt = sdf.parse(sdf.format(date.getTime()));
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }


        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < 8; i++) {
            String url = "http://data.githubarchive.org/" + sdf.format(dt) + "-" + (12 + i) + ".json.gz";
            System.out.println(url);
            String path = "src/main/resources/data.json.gz";
            try {
                HttpRequest.downloadFile(path, url);

                System.out.println("download " + sdf.format(dt) + "-" + (12 + i) + " successfully!");
                getRepoForkMap(path, map);


            } catch (IOException e) {
                e.printStackTrace();

            }
        }

        List<String> list = analyzeTop30Repos(map);


//        ObjectMapper m = new ObjectMapper();
//        List<String> list= new ArrayList<>();
//        try {
//            BufferedInputStream is = new BufferedInputStream(new FileInputStream("src/main/java/edu/nju/data/task/1.txt"));
//            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
//            String line;
//            while ((line = reader.readLine())!=null){
//                list.add(line);
//            }
//            //        list = Arrays.asList(str.substring(1,str.length()-1).split(", "));
//
//            System.out.println(list);
//            saveRepo(list,dt);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        saveRepo(list,dt);
    }


    private void saveRepo(List<String> list,Date date) {
        ObjectMapper mapper = new ObjectMapper();
        JsonFactory f = new JsonFactory();

        for (String repo : list) {
            String s = null;
            try {
                if (dao.selectByFullName(repo) == null) {
                    s = HttpRequest.getGithubContentUsingHttpClient("api.github.com/repos/" + repo);
                    System.out.println(s);

                    Repository po = mapper.readValue(s, Repository.class);
                    if (po.getStargazers_count() + po.getForks_count() < 30)        //对项目star和fork数目限制
                        continue;
                    System.out.println(repo);

                    po.setOwner_name(po.getFull_name().split("/")[0]);
                    String lan = HttpRequest.getGithubContentUsingHttpClient("api.github.com/repos/" + repo + "/languages");
                    po.setLanguages(lan);
                    po.setUpdated_at(date);

                    if(po.getLanguage()==null)
                        po.setLanguage("");

                    //插入项目
                    dao.insert(po);

//                    if (userdao.selectByPrimaryKey(po.getOwner_name()) == null) {
//                        //插入项目主人信息和拥有关系
//                        try {
//                            String owner = HttpRequest.getGithubContentUsingHttpClient("api.github.com/users/" + po.getOwner_name());
//                            User us = mapper.readValue(owner, User.class);
//                            userdao.insert(us);
//                            userdao.insertOwn(us.getLogin(), repo);
//                        } catch (Exception e) {
//                            System.out.println("cant get owner");
//                            e.printStackTrace();
//                        }
//                    }else{
//                        userdao.insertOwn(po.getOwner_name(), repo);
//                    }

                    try {
                        String contri = HttpRequest.getGithubContentUsingHttpClient("api.github.com/repos/" + repo + "/contributors");
                        JsonParser jp = f.createJsonParser(contri);
                        jp.nextToken();

                        //插入贡献关系和贡献者
                        int i =0;
                        while (jp.nextToken() == JsonToken.START_OBJECT&&i<10) {

                            String login = (String) mapper.readValue(jp, Map.class).get("login");

                            dao.insertContribute(repo, login);

                            if (userdao.selectByPrimaryKey(login) == null) {
                                String user = HttpRequest.getGithubContentUsingHttpClient("api.github.com/users/" + login);
                                User us = mapper.readValue(user, User.class);
                                userdao.insert(us);
                            }
                            i++;
                        }
                    } catch (Exception e) {
                        System.out.println("cant get contri");
                    }



                    try {
                        String subs = HttpRequest.getGithubContentUsingHttpClient("api.github.com/repos/" + repo + "/subscribers");
                        JsonParser jp3 = f.createJsonParser(subs);
                        jp3.nextToken();
                        //插入订阅关系和订阅者信息
                        int i=0;
                        while (jp3.nextToken() == JsonToken.START_OBJECT&&i<10) {
                            String login = (String) mapper.readValue(jp3, Map.class).get("login");
                            dao.insertSubscribe(repo, login);

                            if (userdao.selectByPrimaryKey(login) == null) {
                                String user = HttpRequest.getGithubContentUsingHttpClient("api.github.com/users/" + login);
                                User us = mapper.readValue(user, User.class);
                                userdao.insert(us);
                            }
                            i++;
                        }
                    } catch (Exception e) {
                        System.out.println("cant get subscribe");
                    }


                }else{
                    dao.updateUpdatedAt(repo,date);
                }

            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }


        }
    }

    private Map<String, Integer> getRepoForkMap(String path, Map<String, Integer> map) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        BufferedReader br = new BufferedReader(new InputStreamReader(new GZIPInputStream(new FileInputStream(path))));
        String json;
        while ((json = br.readLine()) != null) {

            JsonNode node = mapper.readTree(json);

            if (node.get("type").toString().equals("\"ForkEvent\"")) {
                String name = node.get("repo").get("name").toString().replace("\"", "");
                if (map.containsKey(name)) {
                    map.put(name, map.get(name) + 1);
                } else
                    map.put(name, 1);
            }

        }
        return map;
    }


    /**
     * 分析fork数目最多的前60个项目
     * @param map
     * @return
     */
    private List<String> analyzeTop30Repos(Map<String, Integer> map) {
        System.out.println(sortMapByValue(map).values());
        return new ArrayList<String>(sortMapByValue(map).keySet()).subList(0, 30);
    }


    /**
     * 使用 Map按value进行排序
     *
     * @param
     * @return
     */
    public static Map<String, Integer> sortMapByValue(Map<String, Integer> oriMap) {
        if (oriMap == null || oriMap.isEmpty()) {
            return null;
        }
        Map<String, Integer> sortedMap = new LinkedHashMap<>();
        List<Map.Entry<String, Integer>> entryList = new ArrayList<Map.Entry<String, Integer>>(
                oriMap.entrySet());
        Collections.sort(entryList, new MapValueComparator());

        Iterator<Map.Entry<String, Integer>> iter = entryList.iterator();
        Map.Entry<String, Integer> tmpEntry = null;
        while (iter.hasNext()) {
            tmpEntry = iter.next();
            sortedMap.put(tmpEntry.getKey(), tmpEntry.getValue());
        }
        return sortedMap;


    }

    static class MapValueComparator implements Comparator<Map.Entry<String, Integer>> {

        @Override
        public int compare(Map.Entry<String, Integer> me1, Map.Entry<String, Integer> me2) {

            return me2.getValue().compareTo(me1.getValue());
        }
    }

}
