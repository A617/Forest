package edu.nju.controller;

import edu.nju.data.model.Skill;
import edu.nju.service.RoleService;
import edu.nju.service.SkillService;
import edu.nju.service.vo.RepositoryVO;
import edu.nju.service.vo.SignedInUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dora on 2016/8/30.
 */
@Controller
@SessionAttributes("user")
public class SkillController {

    @Autowired
    SkillService service;
    @Autowired
    RoleService roleService;

    @RequestMapping("/skill/{name}/{level}")
    String showRecommendRepos(@PathVariable("name")String name, @PathVariable("level")int level, Model model, HttpSession session){
        SignedInUser user = LoginHelper.getSignInUser(session);
        List<RepositoryVO> list = null;
        Skill skill = new Skill(name,level);
        model.addAttribute("skill",skill);
        if(user!=null)
            list = service.showRecommendRepos(skill,user.getUsername());
        model.addAttribute("repos",list);
        return "skill";
    }

    @RequestMapping("/skill/levelup")
    @ResponseBody boolean levelup(String skillName, HttpSession session) {
        SignedInUser user = LoginHelper.getSignInUser(session);
        if(user==null||user.getRole()==null)  return false;
        Skill skill = new Skill();
        skill.setName(skillName);
        return service.levelUp(user.getRole(),skill, user.getUsername()) > 0? true:false;
    }
}
