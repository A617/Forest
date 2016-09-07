package edu.nju.service.vo;

import edu.nju.data.model.Member;

/**
 * Created by Dora on 2016/9/7.
 */
public class SignedInUser extends Member {
    protected String avatar;
    protected String token;

    public SignedInUser(Member member) {
        super(member.getUsername(),member.getRole());
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
