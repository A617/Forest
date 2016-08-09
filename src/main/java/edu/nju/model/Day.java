package edu.nju.model;

/**
 * Created by Dora on 2016/5/24.
 */
public class Day{
    int count;
    String date;
    public Day(int count,String date){
        this.count = count;
        this.date = date;
    }
    public int getCount(){
        return count;
    }
    public String getDate(){
        return date;
    }
}
