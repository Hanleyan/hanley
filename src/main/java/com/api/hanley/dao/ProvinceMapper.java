package com.api.hanley.dao;

import com.api.hanley.entity.dto.Province;
import java.util.List;

public interface ProvinceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Province record);

    Province selectByPrimaryKey(Integer id);

    List<Province> selectAll();

    int updateByPrimaryKey(Province record);
}