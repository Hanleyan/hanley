package com.api.hanley.entity.dto;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author hanley
 * @date 2019/4/23 16:44
 * 风萧萧兮易水寒
 */
public class Position {

    private Integer id;//ID
    private String position;//职位名称
    private Date createTime;//创建日期
    private Date updateTime;//修改时间
    private Boolean delFlag;// 是否删除 true 删除  false 未删除  数据库  1 删除 0 未删除

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Boolean getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Boolean delFlag) {
        this.delFlag = delFlag;
    }
}
