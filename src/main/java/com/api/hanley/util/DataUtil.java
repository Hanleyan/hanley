package com.api.hanley.util;

import com.alibaba.excel.metadata.Font;
import com.alibaba.excel.metadata.TableStyle;
import org.apache.poi.ss.usermodel.IndexedColors;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author hanley
 * @date 2019/5/17 11:16
 * 风萧萧兮易水寒
 */
public class DataUtil {

    public static List<List<String>> createExcelTestListStringHead(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        //模型没有注解，表头数据动态传入
        List<List<String>> headList = new ArrayList<List<String>>();

        List<String> headCoulumn1 = new ArrayList<String>();
        List<String> headCoulumn2 = new ArrayList<String>();
        List<String> headCoulumn3 = new ArrayList<String>();
        List<String> headCoulumn4 = new ArrayList<String>();
        List<String> headCoulumn5 = new ArrayList<String>();
        List<String> headCoulumn6 = new ArrayList<String>();

        headCoulumn1.add("统计日期："+format.format(new Date()));headCoulumn1.add("ID");
        headCoulumn2.add(" ");headCoulumn2.add("权限名称");//称
        headCoulumn3.add(" ");headCoulumn3.add("操作权限");
        headCoulumn4.add(" ");headCoulumn4.add("创建日期");
        headCoulumn5.add(" ");headCoulumn5.add("修改时间");
        headCoulumn6.add(" "); headCoulumn6.add("是否删除");

        headList.add(headCoulumn1);
        headList.add(headCoulumn2);
        headList.add(headCoulumn3);
        headList.add(headCoulumn4);
        headList.add(headCoulumn5);
        headList.add(headCoulumn6);
        return headList;
    }

    public static TableStyle createTableStyle(){
        TableStyle  tableStyle = new TableStyle();
        //设置表头样式
        Font headFont = new Font();
        //字体是否加粗
        headFont.setBold(true);
        //字体大小
        headFont.setFontHeightInPoints((short) 15);
        //字体
        headFont.setFontName("楷体");
        tableStyle.setTableHeadFont(headFont);
        //背景色
        tableStyle.setTableHeadBackGroundColor(IndexedColors.GREY_25_PERCENT);


        //设置表格主体样式
        Font contentFont = new Font();
        contentFont.setFontHeightInPoints((short) 12);
        contentFont.setBold(false);
        contentFont.setFontName("黑体");
        tableStyle.setTableContentFont(contentFont);
        tableStyle.setTableContentBackGroundColor(IndexedColors.GOLD);

        return tableStyle;
    }
}
