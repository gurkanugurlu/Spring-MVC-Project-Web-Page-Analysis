package com.ugurlu.gurkan.analysis.mydiffmodels;

public class OsNames {
    private String name;
    private Integer count;

    public String getName() {
        return name;
    }

    public OsNames(String name, Integer count) {
        this.name = name;
        this.count = count;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
