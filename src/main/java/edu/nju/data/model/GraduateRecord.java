package edu.nju.data.model;

import java.util.Date;

public class GraduateRecord {
    protected String username;

    protected String role;

    protected Date time;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "GraduateRecord{" +
                "username='" + username + '\'' +
                ", role='" + role + '\'' +
                ", time=" + time +
                '}';
    }
}