package edu.nju.controller;

import edu.nju.data.model.Role;
import edu.nju.service.MemberService;
import edu.nju.service.RoleService;
import edu.nju.service.vo.SignedInUser;
import edu.nju.service.vo.SkillVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Dora on 2016/8/14.
 */
@Controller
@SessionAttributes("user")
public class GoalController {

    @Autowired
    RoleService service;
    @Autowired
    MemberService memberService;

    @RequestMapping("/hello")
    String showLanding(){
        return "landing";
    }

    @RequestMapping("/goal/{id}")
    String showRole(@PathVariable("id")int id,@RequestParam(required = false)String user, Model model){
        Role role = service.showRole(id);
        model.addAttribute("role",role);
        List<SkillVO> list = service.showSkills(id, user);
        model.addAttribute("skills",list);
        return "goal";
    }

    @RequestMapping("/goal")
    String showGoal(HttpSession session, Model model){

        SignedInUser user = (SignedInUser) session.getAttribute("user");

        if(user==null||user.getRole()==null)
            return "redirect:/select";
        else{
            return "redirect:/goal/" + service.showRole(user.getRole()).getId();
        }

    }



    /**
     * 更改用户的role为roleName
     * @param userName
     * @param roleName
     * @return
     */
    @RequestMapping(value = "/selectRole", method = RequestMethod.POST)
    @ResponseBody
    int selectRole(String userName, String roleName, HttpSession session, SessionStatus sessionStatus){
        int success =  service.selectRole(userName,roleName);
        if(success>0) {
            SignedInUser user = (SignedInUser) session.getAttribute("user");
            user.setRole(memberService.showMember(userName).getRole());
            session.removeAttribute("user");
            session.setAttribute("user", user);
            System.out.println((SignedInUser) session.getAttribute("user"));
        }
        return success;
    }

    @RequestMapping(value = "/select", method = RequestMethod.GET)
    String select(Model model){
        List<Role> list = service.showAllRoles();
        model.addAttribute("roles",list);
        return "roles";
    }
}
