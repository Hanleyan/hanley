package com.api.hanley.entity.pojo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

/**
 * @author hanley
 * @date 2019/9/6 15:29
 * 风萧萧兮易水寒
 */
public class ReadExcelPojo extends BaseRowModel{

    @ExcelProperty(value = "cn", index = 0)
    private String cn;

    @ExcelProperty(value = "adcode", index = 1)
    private String adcode;

    @ExcelProperty(value = "citycode", index = 2)
    private String citycode;

    public String getCn() {
        return cn;
    }

    public void setCn(String cn) {
        this.cn = cn;
    }

    public String getAdcode() {
        return adcode;
    }

    public void setAdcode(String adcode) {
        this.adcode = adcode;
    }

    public String getCitycode() {
        return citycode;
    }

    public void setCitycode(String citycode) {
        this.citycode = citycode;
    }

    @Override
    public String toString() {
        return "ReadExcelPojo{" +
                "cn='" + cn + '\'' +
                ", adcode='" + adcode + '\'' +
                ", citycode='" + citycode + '\'' +
                '}';
    }
}
