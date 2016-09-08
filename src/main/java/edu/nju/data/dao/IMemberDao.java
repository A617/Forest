package edu.nju.data.dao;

import edu.nju.data.model.Member;

/**
 * Created by tjDu on 2016/9/8.
 */
public interface IMemberDao {
    /**
     * 搜member信息
     * @return
     */
    Member showMember(String username);

    /**
     * 增加member
     * @param member
     * @return
     */
    boolean addMember(Member member);
}
