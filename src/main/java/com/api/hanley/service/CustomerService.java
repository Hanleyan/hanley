package com.api.hanley.service;

import com.api.hanley.entity.dto.Customer;

import java.util.List;

/**
 * @author hanley
 * @date 2019/8/20 17:28
 * 风萧萧兮易水寒
 */
public interface CustomerService {

    void add(Customer customer)throws Exception;

    void delete(List<String> ids)throws Exception;

    List<Customer> search(String keywords,String customerName,Integer page, Integer rows)throws Exception;

    public void addTosolr()throws Exception;
}
