package com.api.hanley.dao;

import com.api.hanley.entity.dto.HanziIndex;

import java.util.List;

/**
 * @author hanley
 * @date 2019/5/17 11:30
 * 风萧萧兮易水寒
 */
public interface HanziIndexDao {

    List<HanziIndex> getHanziIndexList();
}
