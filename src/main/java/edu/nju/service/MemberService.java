package edu.nju.service;

import edu.nju.data.model.Member;
import edu.nju.service.vo.SignedInUser;

import java.io.IOException;

/**
 * Created by Dora on 2016/9/6.
 */
public interface MemberService {

    Member showMember(String userName);

    boolean createMember(Member member);

    SignedInUser login(String token) throws IOException;
}
