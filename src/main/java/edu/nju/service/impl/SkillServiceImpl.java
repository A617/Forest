package edu.nju.service.impl;

import edu.nju.data.dao.IMemberDao;
import edu.nju.data.dao.ISkillDao;
import edu.nju.data.model.Repository;
import edu.nju.data.model.Skill;
import edu.nju.service.SkillService;
import edu.nju.service.vo.RepositoryVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tjDu on 2016/8/31.
 */
@Service
public class SkillServiceImpl implements SkillService {
    @Resource
    ISkillDao skillDao;
    @Resource
    IMemberDao memberDao;

    @Override
    public List<RepositoryVO> showRecommendRepos(Skill skill, String userName) {
        List<RepositoryVO> result = new ArrayList<>();
        List<Repository> data = skillDao.showRecommendRepos(skill);
        List<String> learned = memberDao.getLearnedRepos(userName);
        for (Repository repo : data) {
            RepositoryVO repos = new RepositoryVO(repo);
            String name = repo.getFull_name();
            for (String str : learned) {
                if (str.equals(name)) {
                    repos.setLearned(true);
                    break;
                }
            }
            result.add(repos);
        }
        return result;
    }

    @Override
    public int levelUp( Skill skill, String userName) {
        return memberDao.levelUp( skill, userName);
    }
}
