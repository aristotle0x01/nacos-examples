//package com.alibaba.nacos.example.spring.cloud;
//
//import lombok.Data;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.*;
//
//@Data
//public class MyUser implements UserDetails {
//
//    private List<SimpleGrantedAuthority> authorities;
//
//    //加载当前登录用户的权限
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
//        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
//        return authorities;
//    }
//
//    @Override
//    public String getPassword() {
//        return "123456";
//    }
//
//    @Override
//    public String getUsername() {
//        return "user";
//    }
//
//    //父类中需要实现的方法，本 demo 用不上
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    //父类中需要实现的方法，本 demo 用不上
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    //父类中需要实现的方法，本 demo 用不上
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//}
