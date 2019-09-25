package com.example.demo.dao;

import com.example.demo.pojo.Role;
import com.example.demo.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lihu
 * @since 2019-09-25
 */
public interface UserMapper extends BaseMapper<User> {

    User getByName(@Param("name") String name);

    List<Role> getRolesByUserName(@Param("name") String name);
}
