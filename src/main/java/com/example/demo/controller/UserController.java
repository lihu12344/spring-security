package com.example.demo.controller;


import com.example.demo.dao.UserMapper;
import com.example.demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lihu
 * @since 2019-09-25
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @RequestMapping("/save")
    public String save(){
        for(int i=0;i<2;i++){
            User user=new User();
            user.setName("瓜田李下"+i);
            user.setPassword(passwordEncoder.encode("123456"));

            userMapper.insert(user);
        }


        return "success";
    }

    @RequestMapping("/hello")
    public String hello(){
        return "hello world";
    }

    @RequestMapping("/hello2")
    public String hello2(){
        return "hello world2";
    }

    @RequestMapping("/success")
    public String hello3(){
        return "success";
    }

    @RequestMapping("/error")
    public String hello4(){
        return "error";
    }
}

