package edu.nju.service.vo;

import java.util.Date;

/**
 * Created by Dora on 2016/9/10.
 */
public class LearnRecordVO extends RecordVO {

    protected String full_name;

    public LearnRecordVO(String username, String full_name, Date time) {
        super(username,time);
        this.full_name = full_name;
        this.category = RecordCategory.learn;
    }
}
