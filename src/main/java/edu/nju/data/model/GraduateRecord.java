package edu.nju.data.model;

import java.sql.Timestamp;

public class GraduateRecord {
    protected String username;

    protected String role;

    protected Timestamp time;

    public GraduateRecord(String username, String role, Timestamp time) {
        this.username = username;
        this.role = role;
        this.time = time;
    }

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

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
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