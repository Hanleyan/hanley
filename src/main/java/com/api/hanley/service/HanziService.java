package com.api.hanley.service;

import com.api.hanley.dao.HanziIndexDao;
import com.api.hanley.entity.dto.HanziIndex;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author hanley
 * @date 2019/5/17 11:37
 * 风萧萧兮易水寒
 */
public interface HanziService {

    List<HanziIndex> getHanziIndexList();
}
