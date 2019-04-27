package com.example.dao;

import com.example.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/application*.xml")
public class UserDaoTest {

    @Autowired
    private UserDao userDao;
    @Test
    public  void test(){
        List<User> users = userDao.findAll();
        users.forEach(System.out::println);
    }

    @Test
    public  void testFindByUsername(){
        System.out.println(userDao.findByUsername("admin"));

    }



}
