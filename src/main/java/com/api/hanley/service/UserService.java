package com.api.hanley.service;

import com.api.hanley.entity.dto.Users;

import java.util.List;

/**
 * @author hanley
 * @date 2019/6/19 15:34
 * 风萧萧兮易水寒
 */
public interface UserService {

    int deleteByPrimaryKey(Integer id);

    int insert(Users record);

    Users selectByPrimaryKey(Integer id);

    List<Users> selectAll();

    int updateByPrimaryKey(Users record);

    Users selectByUserName(String username);
}
