package edu.nju.data.dao.mapper;

import edu.nju.data.model.Member;
import edu.nju.data.model.StarRepo;
import edu.nju.data.model.Word;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public interface MemberMapper {

    Member searchMember(String userName);
    void addMember(Member member);
    List<String> getWord(String username);
    void addWord(Word word);
    List<String> findWord(String keyword);//根据关键词从项目的描述里模糊搜索出相关的项目名
    List<String> findStarRepo(String username);//返回这个用户名所有收藏的项目名
    void addStarRepo(StarRepo repo_fullname);
    List<String> findMemberByRepo(String repo_fullname);//根据一个项目名找到收藏过它的人的用户名
    void unStarRepo(Map<String,String> params);
    List<LinkedHashMap> countFirst20Keywords();
    List<String> RecommendViaOther(String repo_fullname, String username);
}