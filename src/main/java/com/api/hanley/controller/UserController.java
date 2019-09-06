package com.api.hanley.controller;

import com.api.hanley.entity.dto.Users;
import com.api.hanley.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author hanley
 * @date 2019/6/19 15:39
 * 风萧萧兮易水寒
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/selectUsers")
    public List<Users> selectUsers(){
        return userService.selectAll();
    }

    @RequestMapping(value = "/selectUsersByName/{name}")
    public Users selectUsersByName(@PathVariable String name){
        return userService.selectByUserName(name);
    }
}
