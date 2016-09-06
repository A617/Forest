package edu.nju.controller;

import edu.nju.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Dora on 2016/8/14.
 */
@Controller
public class GoalController {

    @Autowired
    RoleService service;

    @RequestMapping("/hello")
    String showLanding(){
        return "landing";
    }

    @RequestMapping("/goal")
    String showGoal(){
        return "goal";
    }


    @RequestMapping(value = "/selectRole", method = RequestMethod.POST)
    @ResponseBody
    boolean selectRole(String userName, String roleName){
        service.selectRole(userName,roleName);
        return false;
    }

    @RequestMapping(value = "/select", method = RequestMethod.GET)
    String select(){
        return "roles";
    }
}
