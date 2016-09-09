package edu.nju.service.vo;

import edu.nju.data.model.Repository;

/**
 * Created by st0001 on 2016/9/1.
 */
public class RepositoryVO extends Repository {

    protected boolean isLearned;

    public boolean getIsLearned() {
        return isLearned;
    }

    public void setLearned(boolean learned) {
        isLearned = learned;
    }

    public RepositoryVO(Repository repository) {
        setDescription(repository.getDescription());
        setFull_name(repository.getFull_name());
        setClone_url(repository.getClone_url());
        setCreated_at(repository.getCreated_at());
        setForks_count(repository.getForks_count());
        setHomepage(repository.getHomepage());
        setHtml_url(repository.getHtml_url());
        setName(repository.getName());
        setStargazers_count(repository.getStargazers_count());
        setOpen_issues_count(repository.getOpen_issues_count());
        setSize(repository.getSize());
    }


}
