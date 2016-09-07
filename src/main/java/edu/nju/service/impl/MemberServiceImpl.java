package edu.nju.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.nju.data.model.Member;
import edu.nju.data.task.HttpRequest;
import edu.nju.service.MemberService;
import edu.nju.service.vo.SignedInUser;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Created by Dora on 2016/9/7.
 */
@Service
public class MemberServiceImpl implements MemberService {
    @Override
    public Member showMember(String userName) {
        return new Member();
    }

    @Override
    public boolean createMember(Member member) {
        return false;
    }

    @Override
    public SignedInUser login(String token) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String s = HttpRequest.sendGet("api.github.com/user?access_token=" + token);
        String login = mapper.readTree(s).get("login").asText();
        String avatar_url = mapper.readTree(s).get("avatar_url").asText();

        SignedInUser user = new SignedInUser(showMember(login));
        user.setUsername(login);
        user.setAvatar(avatar_url);
        user.setToken(token);
        return user;
    }
}
