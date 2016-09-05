package edu.nju.service.impl;

import edu.nju.data.model.Repository;
import edu.nju.data.model.SimpleRepo;
import edu.nju.data.model.Skill;
import edu.nju.service.SkillService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tjDu on 2016/8/31.
 */
@Service
public class SkillServiceImpl implements SkillService {
    @Override
    public List<SimpleRepo> showRecommendRepos(Skill skill) {
        SimpleRepo repos = new SimpleRepo();
        repos.setName("benschwarz/gallery-css");
        repos.setHtml_url("https://github.com/benschwarz/gallery-css");
        List<SimpleRepo> list = new ArrayList<>();
        list.add(repos);
        return list;
    }
}
