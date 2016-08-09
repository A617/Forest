package edu.nju.model;


import java.sql.Date;
public class Word {
    private Integer watch_word_id;
   private String username;
    private String word;
    private Date watch_word_time;



    public Word(String username, String word, Date watch_word_time) {
        this.username = username;
        this.word = word;
        this.watch_word_time = watch_word_time;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public Date getWatch_word_time() {
        return watch_word_time;
    }

    public void setWatch_word_time(Date watch_word_time) {
        this.watch_word_time = watch_word_time;
    }

    public Integer getWatch_word_id() {
        return watch_word_id;
    }

    public void setWatch_word_id(Integer watch_word_id) {
        this.watch_word_id = watch_word_id;
    }
}