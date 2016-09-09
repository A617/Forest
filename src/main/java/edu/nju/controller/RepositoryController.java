package edu.nju.controller;

import edu.nju.data.model.Repository;
import edu.nju.service.RepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * Created by Dora on 2016/7/27.
 */

@Controller
@SessionAttributes("user")
public class RepositoryController {

    @Autowired
    RepositoryService service;

    @RequestMapping("/repository//{ownerName}/{repoName:.+}")
    String showRepositories(@PathVariable String ownerName, @PathVariable String repoName, Model model){
        String fullName = ownerName + "/" + repoName;
        Repository repository = service.showRepository(fullName);
        model.addAttribute("repo",repository);
        return "repository";

    }

}
