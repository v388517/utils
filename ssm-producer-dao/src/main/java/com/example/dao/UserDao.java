package com.example.dao;

import com.example.pojo.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserDao {
    @Select("select * from user")
    List<User> findAll();

 @Select("select * from user where username=#{username}")
    User findByUsername(String username);
}
