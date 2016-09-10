package edu.nju.data.model;

/**
 * Created by tjDu on 2016/9/5.
 */
public class SimpleRepo {
    private String full_name;
    private String description;
    private String language;

    public SimpleRepo(String full_name, String description, String language) {
        this.full_name = full_name;
        this.description = description;
        this.language = language;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
