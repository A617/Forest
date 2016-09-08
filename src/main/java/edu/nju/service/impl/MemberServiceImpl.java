package edu.nju.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.nju.data.dao.IMemberDao;
import edu.nju.data.model.Member;
import edu.nju.data.task.HttpRequest;
import edu.nju.service.MemberService;
import edu.nju.service.vo.SignedInUser;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * Created by Dora on 2016/9/7.
 */
@Service
public class MemberServiceImpl implements MemberService {
    @Resource
    private IMemberDao dao;

    @Override
    public Member showMember(String userName) {
        return dao.showMember(userName);
    }

    @Override
    public boolean createMember(Member member) {
        return dao.addMember(member);
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
