package edu.nju.service.vo;

import edu.nju.data.model.Member;
import edu.nju.data.model.Repository;

import java.util.Date;

/**
 * Created by Dora on 2016/9/10.
 */
public class LearnRecordVO extends RecordVO {

    protected RepositoryVO repository;

    protected int userid;

    public LearnRecordVO(String username, int userid, Repository repository, Date time) {
        super(username,time);
        this.userid = userid;
        this.repository = new RepositoryVO(repository);
        this.category = RecordCategory.learn;
    }

    @Override
    public String toString() {
        return "LearnRecordVO{" +
                "repository=" + repository +
                ", userid=" + userid +
                "} " + super.toString();
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public Repository getRepository() {
        return repository;
    }

    public void setRepository(RepositoryVO repository) {
        this.repository = repository;
    }
}
