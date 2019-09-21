package com.szp.o2o.entity;

import java.util.Date;

public class HeadLine {

    private Long lindId;

    private String lineName;

    private String lingLink;

    private String lingImg;

    //头条状态 0表示不可用 1表示可用
    private Integer enableStatus;

    //头像优先级
    private Integer priority;

    private Date createTime;

    private Date lastEditTime;

    public Integer getEnableStatus() {
        return enableStatus;
    }

    public void setEnableStatus(Integer enableStatus) {
        this.enableStatus = enableStatus;
    }

    public Long getLindId() {
        return lindId;
    }

    public void setLindId(Long lindId) {
        this.lindId = lindId;
    }

    public String getLineName() {
        return lineName;
    }

    public void setLineName(String lineName) {
        this.lineName = lineName;
    }

    public String getLingLink() {
        return lingLink;
    }

    public void setLingLink(String lingLink) {
        this.lingLink = lingLink;
    }

    public String getLingImg() {
        return lingImg;
    }

    public void setLingImg(String lingImg) {
        this.lingImg = lingImg;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastEditTime() {
        return lastEditTime;
    }

    public void setLastEditTime(Date lastEditTime) {
        this.lastEditTime = lastEditTime;
    }
}
