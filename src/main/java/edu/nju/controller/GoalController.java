package edu.nju.controller;

import edu.nju.data.model.Role;
import edu.nju.service.RoleService;
import edu.nju.service.vo.SignedInUser;
import edu.nju.service.vo.SkillVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping("/hello")
    String showLanding(){
        return "landing";
    }

    @RequestMapping("/goal/{role}")
    String showRole(@PathVariable("role")String role,@RequestParam(required = false)String user, Model model){
        List<SkillVO> list = service.showSkills(role, user);
        model.addAttribute("skills",list);
        return "goal";
    }

    @RequestMapping("/goal")
    String showGoal(HttpSession session, Model model){

        SignedInUser user = (SignedInUser) session.getAttribute("user");

        if(user==null||user.getRole()==null)
            return "redirect:/select";
        else{
            return "redirect:/goal/" + user.getRole();
        }

    }


    @RequestMapping(value = "/selectRole", method = RequestMethod.POST)
    @ResponseBody
    boolean selectRole(String userName, String roleName){
        service.selectRole(userName,roleName);
        return false;
    }

    @RequestMapping(value = "/select", method = RequestMethod.GET)
    String select(Model model){
        List<Role> list = service.showAllRoles();
        model.addAttribute("roles",list);
        return "roles";
    }
}
