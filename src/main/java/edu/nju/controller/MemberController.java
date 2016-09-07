package edu.nju.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.nju.data.task.HttpRequest;
import edu.nju.service.MemberService;
import edu.nju.service.vo.SignedInUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Dora on 2016/9/7.
 */
@Controller
@SessionAttributes("user")
public class MemberController {

    @Value("${client_id}") private String client_id;

    @Value("${client_secret}") private String client_secret;

    @Value("${redirect_uri}") private String redirect_uri;

    @Autowired
    MemberService memberService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(@RequestParam(value = "code", required = false) String code,
                        HttpSession session) {

        if (code == null) {
            return LoginHelper.jumpTo(client_id,redirect_uri);
        } else {
            try {
                String responseString = LoginHelper.jumpBack(client_id,client_secret,code);
                String token = responseString.split("&")[0].substring(13);
                SignedInUser user = memberService.login(token);
                session.setAttribute("user",user);

            } catch (IOException e) {
                e.printStackTrace();
            }

            return "redirect:/";


        }
    }
}
