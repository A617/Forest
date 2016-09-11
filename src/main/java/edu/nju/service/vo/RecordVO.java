package edu.nju.service.vo;

import java.util.Date;

/**
 * Created by Dora on 2016/9/10.
 */
public class RecordVO {
    private static final String months[] = {"Jan","Feb","Mar","April","May","Jun", "Jul","Aug","Sep","Oct","Nov","Dec"};

    protected String username;

    protected Date time;

    protected RecordCategory category;

    protected String month;

    protected int day;

    public RecordVO(String username, Date time) {
        this.username = username;
        this.time = time;
        this.month = months[time.getMonth()];
        this.day = time.getDate();
    }

    private String calculateTimeForShow() {
        return "two days ago";
    }


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

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "RecordVO{" +
                "username='" + username + '\'' +
                ", time=" + time +
                ", category=" + category +
                ", month='" + month + '\'' +
                ", day=" + day +
                '}';
    }
}
