package edu.nju.controller;

import edu.nju.data.model.MemberReport;
import edu.nju.data.model.Repository;
import edu.nju.service.RecordService;
import edu.nju.service.RepositoryService;
import edu.nju.service.vo.LearnRecordVO;
import edu.nju.service.vo.RecordVO;
import edu.nju.service.vo.SignedInUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * Created by Dora on 2016/7/27.
 */

@Controller
@SessionAttributes("user")
public class RepositoryController {

    @Autowired
    RepositoryService service;
    @Autowired
    RecordService recordService;

    @RequestMapping("/repository/{ownerName}/{repoName:.+}")
    String showRepositories(@PathVariable String ownerName, @PathVariable String repoName, Model model){
        String fullName = ownerName + "/" + repoName;
        Repository repository = service.showRepository(fullName);
        model.addAttribute("repo",repository);

        List<LearnRecordVO> list = recordService.getLearnRecordsOfRepo(fullName);
        model.addAttribute("learn",list);

        return "repository";

    }

    @RequestMapping(value = "/repository/learn", method = RequestMethod.POST)
    @ResponseBody  boolean learn(String repoName, HttpSession session){
        SignedInUser user = LoginHelper.getSignInUser(session);
        if(user==null)
            return false;
        return service.learnRepository(user.getUsername(),repoName)>0?true:false;
    }

    @RequestMapping(value = "/repository/report", method = RequestMethod.POST)
    @ResponseBody  boolean report(String repoName, HttpSession session){
        SignedInUser user = LoginHelper.getSignInUser(session);
        if(user==null)
            return false;
        MemberReport report = new MemberReport(user.getUsername(),repoName,1,null,new Timestamp(new Date().getTime()));
        return service.reportRepository(report)>0?true:false;
    }

    @RequestMapping("/repositories")
    String showRepositories(Model model) {
        model.addAttribute("repos",service.showHotRepos());
        return "/repositories";
    }

}
