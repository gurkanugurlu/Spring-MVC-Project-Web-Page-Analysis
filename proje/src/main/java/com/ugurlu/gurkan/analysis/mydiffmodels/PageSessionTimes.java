package com.ugurlu.gurkan.analysis.mydiffmodels;

public class PageSessionTimes {
    private  String name;
    private Double time;

    public PageSessionTimes(String name, Double time) {
        this.name = name;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getTime() {
        return time;
    }

    public void setTime(Double time) {
        this.time = time;
    }
}
