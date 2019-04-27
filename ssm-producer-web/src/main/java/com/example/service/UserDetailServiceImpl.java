package com.example.service;

import com.example.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;


public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        if (StringUtils.isEmpty(username)) {
            throw new RuntimeException();
        }
        User user = userService.findByUsername(username);
        List<GrantedAuthority> grantedAuthorities=new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority(user.getRole()));
        org.springframework.security.core.userdetails.User user1=new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),grantedAuthorities);
        return user1;
    }
}
