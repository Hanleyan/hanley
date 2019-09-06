package com.api.hanley.controller;

import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.metadata.Table;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.alibaba.fastjson.JSON;
import com.api.hanley.entity.dto.Action;
import com.api.hanley.entity.dto.Position;
import com.api.hanley.service.PowerService;
import com.api.hanley.util.DataUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author hanley
 * @date 2019/4/23 16:32
 * 风萧萧兮易水寒
 */
@Slf4j
@Controller
@RequestMapping(value = "/power")
public class PowerController {

    @Autowired
    PowerService powerService;

    @RequestMapping(value = "/getActionByIds")
    @ResponseBody
    public Action getActionById(HttpServletRequest request){
        int actionId = Integer.parseInt(request.getParameter("id"));
        Action action = powerService.getActionById(actionId);
        log.info("action:"+ JSON.toJSON(action));
        return action;
    }
    @RequestMapping(value = "/getActionById/{id}")
    @ResponseBody
    public Action getAction(HttpServletRequest request ,@PathVariable int id){  //@PathVariable( "id" ) int id
        //int actionId = Integer.parseInt(request.getParameter("id"));
        log.info("请求路径进来id："+id);
        Action action = powerService.getActionById(id);
        log.info("action:"+ JSON.toJSON(action));
        return action;
    }
    @RequestMapping(value = "/getActionList")
    @ResponseBody
    public List getActionList(HttpServletRequest request){
        List<Action> actionList = powerService.getActionList();
        log.info("action:"+ JSON.toJSON(actionList));
        return actionList;
    }

    @RequestMapping(value = "/getPositionById")
    @ResponseBody
    public Position getPositionById(HttpServletRequest request){
        int positionId = Integer.parseInt(request.getParameter("id"));
        Position position = powerService.getPositionById(positionId);
        return position;
    }

    @RequestMapping(value = "/addAction")
    @ResponseBody
    public Action addAction(String action,String actionPath){
        //int positionId = Integer.parseInt(request.getParameter("id"));
        Action act = new Action();
        act.setAction(action);
        act.setActionPath(actionPath);
        act.setCreateTime(new Date());
        act.setDelFlag(false);
        act.setUpdateTime(new Date());


        int i = powerService.addAction(act);
        log.info("插入了"+i+"条");
        return act;
    }

    /**
     * 下载Excel    http://192.168.1.157:8086/power/downloadExcel
     * @param request request
     * @param response response
     * @throws Exception Exception
     */
    @GetMapping("/downloadExcel")
    public void cooperation(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String fileName = new String(("UserInfo订单表" + new SimpleDateFormat("yyyy-MM-dd").format(new Date())).getBytes(), "UTF-8");

        response.setContentType("multipart/form-data");
        response.setCharacterEncoding("utf-8");
        //response.setHeader("Content-disposition", "attachment;filename="+fileName+".xlsx");
        response.setHeader("Content-Disposition", "attachment;filename="
                + new String(fileName.getBytes("UTF-8"), "ISO-8859-1")
                + ".xls");

        ServletOutputStream out = response.getOutputStream();
        ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLS, true);

        Sheet sheet1 = new Sheet(1, 0);
        sheet1.setSheetName("第一个sheet");

        //创建一个表格，动态添加表头
        Table table1 = new Table(1);
        //自定义表格样式
        table1.setTableStyle(DataUtil.createTableStyle());
        //无注解的模式，动态添加表头
        table1.setHead(DataUtil.createExcelTestListStringHead());
        writer.write1(powerService.getActionObjectList(), sheet1,table1);
        writer.finish();

        out.flush();
    }
}
