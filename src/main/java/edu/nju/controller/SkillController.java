package edu.nju.controller;

import edu.nju.data.model.Repository;
import edu.nju.service.vo.RepositoryVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dora on 2016/8/30.
 */
@Controller
public class SkillController {

    @RequestMapping("/skill")
    String showSkill(Model model){
        List<RepositoryVO> list = new ArrayList<>();
        RepositoryVO repo1 = new RepositoryVO();
        repo1.setFull_name("repository1");
        repo1.setDescription("description1");
        repo1.setLearned(true);
        RepositoryVO repo2 = new RepositoryVO();
        repo2.setFull_name("repository2");
        repo2.setDescription("description2");
        repo2.setLearned(true);
        RepositoryVO repo3 = new RepositoryVO();
        repo3.setFull_name("repository3");
        repo3.setDescription("description3");
        repo3.setLearned(false);
        RepositoryVO repo4 = new RepositoryVO();
        repo4.setFull_name("repository4");
        repo4.setDescription("description4");
        repo4.setLearned(false);
        list.add(repo1);
        list.add(repo2);
        list.add(repo3);
        list.add(repo4);
        model.addAttribute("repos",list);
        return "skill";
    }

}
