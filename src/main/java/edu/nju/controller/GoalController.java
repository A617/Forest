package edu.nju.controller;

import edu.nju.data.model.GraduateRecord;
import edu.nju.data.model.Role;
import edu.nju.data.model.Skill;
import edu.nju.service.MemberService;
import edu.nju.service.RecordService;
import edu.nju.service.RoleService;
import edu.nju.service.vo.SignedInUser;
import edu.nju.service.vo.SkillVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.Date;
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
    @Autowired
    RecordService recordService;

    @RequestMapping("/hello")
    String showLanding(){
        return "landing";
    }

    @RequestMapping("/goal/{id}")
    String showRole(@PathVariable("id")int id, Model model, HttpSession session){
        Role role = service.showRole(id);
        model.addAttribute("role",role);

        SignedInUser signedInUser = (SignedInUser) session.getAttribute("user");

        if(signedInUser!=null && signedInUser.getRole()!=null && signedInUser.getRole().equals(role.getName())){
            // 浏览本人的role skills
            List<SkillVO> list = service.showSkills(id, signedInUser.getUsername());
            System.out.println("本人");
            System.out.println(list);
            model.addAttribute("skills",list);
            for (SkillVO vo:list){
                if(vo.getProgress()<100)
                    return "goal";
            }
            model.addAttribute("graduate",1);
            recordService.addGraduateRecord(new GraduateRecord(signedInUser.getUsername(),role.getName(), new Timestamp(new Date().getTime())));
        }else{
            //浏览的role非本人选择
            List<Skill> list = service.showCommonSkills(id);
            System.out.println("非本人");
            System.out.println(list);
            model.addAttribute("skills",list);
        }
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

    @RequestMapping("/index")
    String index(Model model){
        return select(model);
    }
}
