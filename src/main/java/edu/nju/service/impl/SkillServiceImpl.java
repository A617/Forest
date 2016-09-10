package edu.nju.service.impl;

import edu.nju.data.dao.IMemberDao;
import edu.nju.data.dao.IRoleDao;
import edu.nju.data.dao.ISkillDao;
import edu.nju.data.model.Repository;
import edu.nju.data.model.Skill;
import edu.nju.service.SkillService;
import edu.nju.service.vo.RepositoryVO;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    IRoleDao roleDao;

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
    public int levelUp(String roleName, Skill skill, String userName) {
        Skill sk = skillDao.getSkills(roleName,skill.getName());
        if(sk==null)    return 0;
        int highestLevel = sk.getLevel();
        if(skill.getLevel()+1<highestLevel)
            return memberDao.levelUp( skill, userName);
        //  升级后达到最大等级也返回false
        if(skill.getLevel()+1==highestLevel)
            memberDao.levelUp( skill, userName);
        return 0;
    }
}
