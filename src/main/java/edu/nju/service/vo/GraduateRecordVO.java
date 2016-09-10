package edu.nju.service.vo;

import java.util.Date;

/**
 * Created by Dora on 2016/9/10.
 */
public class GraduateRecordVO extends RecordVO{

    protected String role;

    public GraduateRecordVO(String username, String role, Date time) {
        this.role = role;
        this.category = RecordCategory.graduate;
        this.time = time;
        this.username = username;
    }
}
