package edu.nju.service.vo;

import java.util.Date;

/**
 * Created by Dora on 2016/9/10.
 */
public class LearnRecordVO extends RecordVO {

    protected String full_name;

    public LearnRecordVO(String username, String full_name, Date time) {
        this.username = username;
        this.full_name = full_name;
        this.time = time;
        this.category = RecordCategory.learn;
    }
}
