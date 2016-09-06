package edu.nju.service;

import edu.nju.data.model.Member;

/**
 * Created by Dora on 2016/9/6.
 */
public interface MemberService {

    Member showMember(String userName);

    boolean createMember(Member member);
}
