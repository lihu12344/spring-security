package com.example.demo.serviceImpl;

import com.example.demo.dao.UserMapper;
import com.example.demo.pojo.Role;
import com.example.demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserService implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user=userMapper.getByName(s);

        List<Role> roleList=userMapper.getRolesByUserName(s);
        List<GrantedAuthority> list=new ArrayList<>();
        for(Role role:roleList){
            list.add(new SimpleGrantedAuthority(role.getRole()));
        }

        return new org.springframework.security.core.userdetails.User
                (user.getName(),user.getPassword(),list);
    }
}
