package edu.nju.controller;

import edu.nju.service.RepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Dora on 2016/7/27.
 */

@Controller
public class RepositoryController {

    @Autowired
    RepositoryService service;

    @RequestMapping("/hello")
    String sayHello(){
        return "index";
    }
}
