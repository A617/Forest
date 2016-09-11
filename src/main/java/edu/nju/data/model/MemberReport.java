package edu.nju.data.model;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

public class MemberReport {
    private String username;

    private String fullName;

    private Integer evaluate;

    private String reason;

    private Timestamp time;

    public MemberReport(String username, String fullName, Integer evaluate, String reason,Timestamp time) {
        this.username = username;
        this.fullName = fullName;
        this.evaluate = evaluate;
        this.reason = reason;
        this.time = time;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getEvaluate() {
        return evaluate;
    }

    public void setEvaluate(Integer evaluate) {
        this.evaluate = evaluate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }
}