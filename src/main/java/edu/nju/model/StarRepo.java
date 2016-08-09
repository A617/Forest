package edu.nju.model;

import java.sql.Date;

public class StarRepo {
    private Integer watch_id;

    private String username;

    private String repo_fullname;

    private Date watch_repo_time;

    public StarRepo(String username, String repo_fullname, Date watch_repo_time) {
        this.username = username;
        this.repo_fullname = repo_fullname;
        this.watch_repo_time = watch_repo_time;
    }
    public StarRepo(){

    }
    public Integer getWatch_id() {
        return watch_id;
    }

    public void setWatch_id(Integer watch_id) {
        this.watch_id = watch_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRepo_fullname() {
        return repo_fullname;
    }

    public void setRepo_fullname(String repo_fullname) {
        this.repo_fullname = repo_fullname;
    }

    public Date getWatch_repo_time() {
        return watch_repo_time;
    }

    public void setWatch_repo_time(Date watch_repo_time) {
        this.watch_repo_time = watch_repo_time;
    }
}