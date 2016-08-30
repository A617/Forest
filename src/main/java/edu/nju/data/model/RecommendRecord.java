package edu.nju.data.model;

/**
 * Created by Dora on 2016/6/6.
 * 根据key推荐的full_name2项目
 */
public class RecommendRecord {
    String key;
    String full_name;

    public RecommendRecord(String key, String full_name) {
        this.key = key;
        this.full_name = full_name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getFull_name() {
        return full_name;
    }

    @Override
    public String toString() {
        return "RecommendRecord{" +
                "key='" + key + '\'' +
                ", full_name='" + full_name + '\'' +
                '}';
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }
}
