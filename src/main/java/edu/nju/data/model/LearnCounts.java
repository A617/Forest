package edu.nju.data.model;

import java.sql.Timestamp;

/**
 * Created by Dora on 2016/10/10.
 */
public class LearnCounts {
    private Timestamp time;
    private int count;

    public LearnCounts(Timestamp time, int count) {
        this.time = time;
        this.count = count;
    }

    public LearnCounts() {
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "LearnCounts{" +
                "time=" + time +
                ", count=" + count +
                '}';
    }
}
