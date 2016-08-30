package edu.nju.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Dora on 2016/8/30.
 */
@Controller
public class SkillController {

    @RequestMapping("/skill")
    String showSkill(){
        return "skill";
    }

}
