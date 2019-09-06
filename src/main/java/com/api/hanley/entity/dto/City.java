package com.api.hanley.entity.dto;

import java.io.Serializable;

public class City implements Serializable {
    /*
    id	int	11	0	0	-1	0	0	0		0					-1	0
pro_id	int	11	0	-1	0	0	0	0		0	省份id				0	0
cn	varchar	20	0	-1	0	0	0	0		0		utf8	utf8_general_ci		0	0
adcode	varchar	10	0	-1	0	0	0	0		0	地区编码	utf8	utf8_general_ci		0	0
citycode	varchar	10	0	-1	0	0	0	0		0	城市区段	utf8	utf8_general_ci		0	0

     */
    private Integer id;

    private Integer pro_id;

    private String cn;

    private String adcode;

    private String citycode;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPro_id() {
        return pro_id;
    }

    public void setPro_id(Integer pro_id) {
        this.pro_id = pro_id;
    }

    public String getCn() {
        return cn;
    }

    public void setCn(String cn) {
        this.cn = cn == null ? null : cn.trim();
    }

    public String getAdcode() {
        return adcode;
    }

    public void setAdcode(String adcode) {
        this.adcode = adcode == null ? null : adcode.trim();
    }

    public String getCitycode() {
        return citycode;
    }

    public void setCitycode(String citycode) {
        this.citycode = citycode == null ? null : citycode.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", pro_id=").append(pro_id);
        sb.append(", cn=").append(cn);
        sb.append(", adcode=").append(adcode);
        sb.append(", citycode=").append(citycode);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}