package com.api.hanley.service.impl;

import com.api.hanley.dao.HanziIndexDao;
import com.api.hanley.entity.dto.HanziIndex;
import com.api.hanley.entity.pojo.CesNewObj;
import com.api.hanley.service.HanziService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hanley
 * @date 2019/5/17 11:38
 * 风萧萧兮易水寒
 */
@Slf4j
@Service("hanziServiceImpl")
public class HanziServiceImpl implements HanziService{
    @Autowired
    HanziIndexDao hanziIndexDao;

    @Override
    public List<HanziIndex> getHanziIndexList() {
        return hanziIndexDao.getHanziIndexList();
    }

    @Scheduled(cron="0 38 11 * * ?")
    public void ce1(){
        CesNewObj cesNewObj = new CesNewObj();
        cesNewObj.setName("Name1");
        System.out.println(cesNewObj.toString());
        log.info(cesNewObj.toString());
    }

    @Scheduled(cron="0 39 11 * * ?")
    public void ce2(){
        CesNewObj cesNewObj = new CesNewObj();
        cesNewObj.setName("Name2");
        System.out.println(cesNewObj.toString());
        log.info(cesNewObj.toString());
    }
}
