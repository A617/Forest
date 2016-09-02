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
}
