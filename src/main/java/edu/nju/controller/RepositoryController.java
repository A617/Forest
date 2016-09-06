package edu.nju.controller;

import edu.nju.service.RepositoryService;
import edu.nju.service.vo.RepositoryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Dora on 2016/7/27.
 */

@Controller
public class RepositoryController {

    @Autowired
    RepositoryService service;

    @RequestMapping("/repository/{id}")
    String showRepositories(@PathVariable("id")String id, Model model){

        RepositoryVO repository = new RepositoryVO();
        repository.setFull_name("repository");
        repository.setDescription("description");

        model.addAttribute("repo",repository);
        return "repository";

    }

}
