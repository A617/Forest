package edu.nju.controller;

import edu.nju.data.model.Skill;
import edu.nju.data.model.User;
import edu.nju.service.MemberService;
import edu.nju.service.RecordService;
import edu.nju.service.RoleService;
import edu.nju.service.SkillService;
import edu.nju.service.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    @Autowired
    RoleService roleService;
    @Autowired
    RecordService recordService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    String login(@RequestParam(value = "code", required = false) String code,
                        HttpSession session, @RequestParam(value="formerUrl", defaultValue = "/select")String formerUrl) {

        if (code == null) {
            return LoginHelper.jumpTo(client_id, redirect_uri+"?formerUrl="+formerUrl);

        } else {
            try {
                String responseString = LoginHelper.jumpBack(client_id,client_secret,code);
                String token = responseString.split("&")[0].substring(13);
                SignedInUser user = memberService.login(token);
                System.out.println(user);
                session.setAttribute("user",user);

            } catch (IOException e) {
                e.printStackTrace();
            }
            return "redirect:" + formerUrl;
        }
    }

    @RequestMapping("/logout")
    String logout(HttpSession session, SessionStatus sessionStatus, @RequestParam("formerUrl")String formerUrl){
        if(session.getAttribute("user")!=null) {
            session.removeAttribute("user");
            sessionStatus.setComplete();
        }
        return "redirect:" + formerUrl;
    }

    @RequestMapping("/achievements/{username}")
    String showAchievements(@PathVariable("username") String username, Model model, HttpSession session){
        List<RecordVO> recordVOs= recordService.getUserRecords(username);
        model.addAttribute("records",recordVOs);

        List<SkillVO> skillVOs = roleService.getUserMasterSkills(username);
        model.addAttribute("skills",skillVOs);

        SignedInUser signedInUser = LoginHelper.getSignInUser(session);
        try {
            User user  = memberService.getUserDetail(username, signedInUser.getToken());
            model.addAttribute("detail",user);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "achievements";
    }

    @RequestMapping("/achievements")
    String showMyAchievements(HttpSession session){
        SignedInUser user = LoginHelper.getSignInUser(session);
        return "redirect:/achievements/"+user.getUsername();
    }
}
