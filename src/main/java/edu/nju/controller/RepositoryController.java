package edu.nju.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Dora on 2016/7/27.
 */

@Controller
public class RepositoryController {

    @RequestMapping("/hello")
    String sayHello(){
        System.out.println("hello");
        return "index";
    }
}
