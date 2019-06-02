package com.ugurlu.gurkan.analysis.mydiffmodels;

public class Counts {
    Integer indexCount=0;
    Integer aboutCount=0;
    Integer singleCount=0;
    Integer contactCount=0;

    public Counts(Integer indexCount, Integer aboutCount, Integer singleCount, Integer contactCount) {
        this.indexCount = indexCount;
        this.aboutCount = aboutCount;
        this.singleCount = singleCount;
        this.contactCount = contactCount;
    }

    public Integer getIndexCount() {
        return indexCount;
    }

    public void setIndexCount(Integer indexCount) {
        this.indexCount = indexCount;
    }

    public Integer getAboutCount() {
        return aboutCount;
    }

    public void setAboutCount(Integer aboutCount) {
        this.aboutCount = aboutCount;
    }

    public Integer getSingleCount() {
        return singleCount;
    }

    public void setSingleCount(Integer singleCount) {
        this.singleCount = singleCount;
    }

    public Integer getContactCount() {
        return contactCount;
    }

    public void setContactCount(Integer contactCount) {
        this.contactCount = contactCount;
    }
}
