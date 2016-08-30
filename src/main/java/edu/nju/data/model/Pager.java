package edu.nju.data.model;

/**
 * Created by phoebegl on 16/8/9.
 */
import java.util.List;

public class Pager<T> {
    private List<T> datas;
    private int offset;
    private int size;
    // private long total;

    public Pager() {
    }

    public Pager(List<T> datas, int offest, int size) {
        this.datas = datas;
        this.offset = offest;
        this.size = size;

    }

    public List<T> getDatas() {
        return datas;
    }

    public void setDatas(List<T> datas) {
        this.datas = datas;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }


}

