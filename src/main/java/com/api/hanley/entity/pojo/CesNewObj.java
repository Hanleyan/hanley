package com.api.hanley.entity.pojo;

import java.util.Date;

/**
 * @author hanley
 * @date 2019/6/10 11:25
 * 风萧萧兮易水寒
 */
public class CesNewObj {

    private String name;
    private Date creatrTime = new Date();
    private Date updateTime = new Date();

    public CesNewObj() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreatrTime() {
        return creatrTime;
    }

    public void setCreatrTime(Date creatrTime) {
        this.creatrTime = creatrTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "CesNewObj{" +
                "name='" + name + '\'' +
                ", creatrTime=" + creatrTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
