package edu.nju.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Dora on 2016/8/14.
 */
@Controller
public class GoalController {

    @RequestMapping("/hello")
    String showLanding(){
        return "landing";
    }

    @RequestMapping("/goal")
    String showGoal(){
        return "goal";
    }
}
