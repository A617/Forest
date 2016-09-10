package edu.nju.service.vo;

import java.util.Date;

/**
 * Created by Dora on 2016/9/10.
 */
public class RecordVO {
    protected String username;

    protected Date time;

    protected RecordCategory category;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public RecordCategory getCategory() {
        return category;
    }

    public void setCategory(RecordCategory category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "RecordVO{" +
                "username='" + username + '\'' +
                ", time=" + time +
                ", category=" + category +
                '}';
    }
}
