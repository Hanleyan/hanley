package com.api.hanley.entity.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

/**
 * @author hanley
 * @date 2019/5/17 11:29
 * 风萧萧兮易水寒
 */
public class HanziIndex  extends BaseRowModel{

    @ExcelProperty(value = "ID",index = 0)
    private Integer id;//ID

    @ExcelProperty(value = "汉字",index = 1)
    private String hanzi;//

    @ExcelProperty(value = "创建日期",index = 2)
    private String createDate;//创建日期

    @ExcelProperty(value = "修改日期",index = 3)
    private String updateTime;

    @ExcelProperty(value = "是否删除",index = 4)
    private String delFlag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHanzi() {
        return hanzi;
    }

    public void setHanzi(String hanzi) {
        this.hanzi = hanzi;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }
}
