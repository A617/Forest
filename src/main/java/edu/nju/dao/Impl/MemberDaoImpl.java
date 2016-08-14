package edu.nju.dao.Impl;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.nju.dao.MemberDao;
import edu.nju.dao.mapper.MemberMapper;
import edu.nju.model.*;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.*;

/**
 * Created by phoebegl on 16/8/9.
 */
@org.springframework.stereotype.Repository
public class MemberDaoImpl implements MemberDao{

    @Resource
    private MemberMapper mapper;

    @Override
    public String searchMember(Member member){
        String name = member.getUsername();
        Member data = mapper.searchMember(name);
        if (data == null) {
            return "用户名不存在";
        } else {
            if (!data.getPassword().equals(member.getPassword()))
                return "密码错误";
        }
        return null;
    }

    @Override
    public String addMember(Member member){
        String name = member.getUsername();
        Member data = mapper.searchMember(name);
        if (data != null) {
            return "用户名重复";
        } else {
            if (member.getPassword().length() < 6) {
                return "密码长度要大于等于6";
            } else {
                mapper.addMember(member);
                return null;
            }

        }
    }

    @Override
    public String addMemberByGit(String username){
        Member mem=new Member(username);
        Member data = mapper.searchMember(username);
        if (data != null) {
            return "用户名重复";
        } else {
            mapper.addMember(mem);
            return null;
        }
    }

    @Override
    public List<RecommendRecord> getRecommendBySearched(String userName){
        List<RecommendRecord> map = new ArrayList<RecommendRecord>();
        List<String> wordList = getSearchKey(userName);
        for(String word:wordList){
            for(String repo_name : mapper.findWord(word))
                map.add(new RecommendRecord(word,repo_name));
        }
        return map;
    }

    @Override
    public List<Repository> getStaredRepos(String userName, String token) throws IOException{
//        String s = HttpRequest.getGithubContentUsingHttpClient(token, "api.github.com/users/" + login + "/starred");
        List<Repository> list = new ArrayList<>();
//
//        ObjectMapper mapper = new ObjectMapper();
//        JsonFactory f = new JsonFactory();
//
//        if (s!=null&&!s.equals("[]")) {
//            list = mapper.readValue(s,new TypeReference<List<Repository>>() {});
//        }
        return list;
    }

    @Override
    public List<String> getStaredRepos(String userName){
        return mapper.findStarRepo(userName);
    }

    @Override
    public  List<RecommendRecord> getRecommendByOther(String userName){
        // 搜索他收藏的项目(仅仅是收藏)，找到也收藏这个项目的别人，再搜索这些别人的收藏的其他项目。
        List<RecommendRecord> map = new ArrayList<>();
        List<String>user_star_repo = mapper.findStarRepo(userName);

        for(String repo:user_star_repo){
            List<String>list=mapper.RecommendViaOther(repo,userName);
            if(list!=null) {
                for (String str : list) {
                    if(!repo.equals(str))
                        map.add(new RecommendRecord(repo, str));
                }
            }
        }
        return map;
    }

    @Override
    public void addShareRepo(StarRepo repo){
        if (repo != null && !repo.getRepo_fullname().isEmpty()) {
            String user = repo.getUsername();
            List<String> repos = mapper.findStarRepo(user);
            if(!repos.contains(repo.getRepo_fullname())) {
                mapper.addStarRepo(repo);
            }
        }
    }

    @Override
    public void unStarRepo(String userName,String repository){
        Map<String,String> map = new HashMap<>();
        map.put("userName",userName);
        map.put("repository",repository);
        mapper.unStarRepo(map);
    }

    @Override
    public void addWord(Word word){
        mapper.addWord(word);
    }

//    private Map<String, Object> createMap() {
//        Map<String, Object> map = new HashMap<String, Object>();
//        int pageSize = SystemContext.getSize();
//        int pageOffset = SystemContext.getOffset();
//        map.put("pageSize", pageSize);
//        map.put("pageOffset", pageOffset);
//        return map;
//    }

    private List<String> getSearchKey(String userName) {
        List<String> wordList = mapper.getWord(userName);//wordList中包含该用户搜索的所有关键词
        for (int i = 0; i < wordList.size(); i++) {
            wordList.get(i).toLowerCase();
            if (!Statistics.tag.contains(wordList.get(i))) {
                wordList.remove(i);
            }
        }
        HashSet h = new HashSet(wordList);
        wordList.clear();
        wordList.addAll(h);
        return wordList;
    }
}

