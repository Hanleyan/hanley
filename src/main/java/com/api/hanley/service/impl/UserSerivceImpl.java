package com.api.hanley.service.impl;

import com.api.hanley.dao.UsersMapper;
import com.api.hanley.entity.dto.Users;
import com.api.hanley.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hanley
 * @date 2019/6/19 15:35
 * 风萧萧兮易水寒
 */
@Service("userService")
public class UserSerivceImpl implements UserService {

    @Autowired
    UsersMapper usersMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return usersMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Users record) {
        return usersMapper.insert(record);
    }

    @Override
    public Users selectByPrimaryKey(Integer id) {
        return usersMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Users> selectAll() {
        return usersMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(Users record) {
        return usersMapper.updateByPrimaryKey(record);
    }

    @Override
    public Users selectByUserName(String username) {
        return usersMapper.selectByUserName(username);
    }
}
