package edu.nju.dao;

import edu.nju.model.*;

import java.io.IOException;
import java.util.List;

/**
 * Created by phoebegl on 16/8/9.
 */
public interface MemberDao {
    /**
     * 查找member
     * @param member
     * @return
     */
    String searchMember(Member member);

    /**
     * 增加member
     * @param member
     * @return
     */
    String addMember(Member member);
    /**
     * 增加member,是根据github用户名创建。如果这个用户名之前已经有了，则返回重名信息。
     * @param username
     * @return
     */
    String addMemberByGit(String username);

    /**
     * 根据搜索记录(包括点击过的tag）获取该会员的推荐repository名单
     * @param userName
     * @return
     */
    List<RecommendRecord> getRecommendBySearched(String userName);

    /**
     *
     * @param userName
     * @return member收藏的项目名称
     */
    List<Repository> getStaredRepos(String userName, String token) throws IOException;

    List<String> getStaredRepos(String userName);

    /**
     *
     * @param userName
     * @return 收藏了该项目的其他member还收藏的其他项目.传进来一个用户名(注意是当前登录的用户的名字！)，搜索他收藏的项目(注意仅仅是收藏，不是搜索关键字得到的)，找到也收藏这个项目的别人，再搜索这些别人的收藏的其他项目。
     */
    List<RecommendRecord> getRecommendByOther(String userName);

    /**
     * 收藏项目
     * @param repo
     */
    void addShareRepo(StarRepo repo);

    /**
     * 取消收藏
     * @param repository
     * @param userName
     * @return
     */
    void unStarRepo(String userName,String repository);
    /**
     * 增加关键词
     * @param word
     * @return
     */
    void addWord(Word word);
}
