package edu.nju.service.vo;

import edu.nju.data.model.Repository;

import java.util.Date;

/**
 * Created by Dora on 2016/9/10.
 */
public class LearnRecordVO extends RecordVO {

    protected Repository repository;

    public LearnRecordVO(String username, Repository repository, Date time) {
        super(username,time);
        this.repository = repository;
        this.category = RecordCategory.learn;
    }

    @Override
    public String toString() {
        return "LearnRecordVO{" +
                "repository=" + repository +
                "} " + super.toString();
    }

    public Repository getRepository() {
        return repository;
    }

    public void setRepository(Repository repository) {
        this.repository = repository;
    }
}
