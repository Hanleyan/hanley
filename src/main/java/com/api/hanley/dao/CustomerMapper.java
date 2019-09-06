package com.api.hanley.dao;

import com.api.hanley.entity.dto.Customer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Customer record);

    Customer selectByPrimaryKey(Integer id);

    List<Customer> selectAll();

    List<Customer> selectAllLimit(@Param("l1") Integer l1, @Param("l2") Integer l2);


    int updateByPrimaryKey(Customer record);
}