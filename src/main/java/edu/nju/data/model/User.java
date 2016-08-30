package edu.nju.data.model;

import java.util.Date;

public class User {
    private String login;

    private String html_url;

    private String type;

    private String avatar_url;

    private String name;

    private String location;

    private String email;

    private String blog;

    private String company;

    private Integer public_repos;

    private Integer public_gists;

    private Integer followers;

    private Integer following;

    private Date created_at;

    private Date updated_at;

    private Double popular_score;

    private Double teamwork_score;

    private Double liveness_score;

    private Double experience_score;

    private Double quantity_score;

    private String languages;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getHtml_url() {
        return html_url;
    }

    public void setHtml_url(String html_url) {
        this.html_url = html_url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBlog() {
        return blog;
    }

    public void setBlog(String blog) {
        this.blog = blog;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Integer getPublic_repos() {
        return public_repos;
    }

    public void setPublic_repos(Integer public_repos) {
        this.public_repos = public_repos;
    }

    public Integer getPublic_gists() {
        return public_gists;
    }

    public void setPublic_gists(Integer public_gists) {
        this.public_gists = public_gists;
    }

    public Integer getFollowers() {
        return followers;
    }

    public void setFollowers(Integer followers) {
        this.followers = followers;
    }

    public Integer getFollowing() {
        return following;
    }

    public void setFollowing(Integer following) {
        this.following = following;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public Double getPopular_score() {
        return popular_score;
    }

    public void setPopular_score(Double popular_score) {
        this.popular_score = popular_score;
    }

    public Double getTeamwork_score() {
        return teamwork_score;
    }

    public void setTeamwork_score(Double teamwork_score) {
        this.teamwork_score = teamwork_score;
    }

    public Double getLiveness_score() {
        return liveness_score;
    }

    public void setLiveness_score(Double liveness_score) {
        this.liveness_score = liveness_score;
    }

    public Double getExperience_score() {
        return experience_score;
    }

    public void setExperience_score(Double experience_score) {
        this.experience_score = experience_score;
    }

    public Double getQuantity_score() {
        return quantity_score;
    }

    public void setQuantity_score(Double quantity_score) {
        this.quantity_score = quantity_score;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }
}