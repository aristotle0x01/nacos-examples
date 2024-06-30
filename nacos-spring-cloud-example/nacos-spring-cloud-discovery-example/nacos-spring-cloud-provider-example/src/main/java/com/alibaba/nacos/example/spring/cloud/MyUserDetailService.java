//package com.alibaba.nacos.example.spring.cloud;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import javax.servlet.http.HttpServletRequest;
//import java.util.ArrayList;
//import java.util.List;
//
////用户登录时，会把用户名传过来，从数据库中查询获取当前要登录的用户信息
//// @Service
//public class MyUserDetailService implements UserDetailsService {
//
//    @Autowired
//    private HttpServletRequest request;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        String token = request.getHeader("user");
//        if (token == null) {
//            return new MyUser();
//        }
//
//        // 再进一步去redis获取用户登录信息
//
//        if (token.startsWith("user")) {
//            MyUser userDetails = new MyUser();
//            List<SimpleGrantedAuthority> authorities = new ArrayList<>();
//            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
//            userDetails.setAuthorities(authorities);
//            return userDetails;
//        } else if (token.startsWith("admin")) {
//            MyUser userDetails = new MyUser();
//            List<SimpleGrantedAuthority> authorities = new ArrayList<>();
//            authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
//            userDetails.setAuthorities(authorities);
//            return userDetails;
//        } else {
//            return new MyUser();
//        }
//    }
//}
