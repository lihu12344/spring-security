package com.example.demo.controller;

import com.example.demo.dao.UserMapper;
import com.example.demo.pojo.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/get")
    public List<Role> get(){
        System.out.println(userMapper.getRolesByUserName("瓜田李下0"));

        return userMapper.getRolesByUserName("瓜田李下1");
    }

}
