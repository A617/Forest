package edu.nju.service.impl;

import edu.nju.data.model.Skill;
import edu.nju.service.SkillService;
import edu.nju.service.vo.RepositoryVO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tjDu on 2016/8/31.
 */
@Service
public class SkillServiceImpl implements SkillService {
    @Override
    public List<RepositoryVO> showRecommendRepos(Skill skill,String userName) {
        RepositoryVO repos = new RepositoryVO();
        repos.setName("benschwarz/gallery-css");
        repos.setHtml_url("https://github.com/benschwarz/gallery-css");
        List<RepositoryVO> list = new ArrayList<>();
        list.add(repos);
        return list;
    }
}
