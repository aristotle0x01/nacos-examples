//package com.alibaba.nacos.example.spring.cloud.bak;
//
//import com.alibaba.nacos.example.spring.cloud.MyUserDetailService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.ProviderManager;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//
//import java.util.ArrayList;
//import java.util.List;
//
//// @Configuration
//public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    // Create 2 users for demo
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication();
////        auth.inMemoryAuthentication()
////                .withUser("user").password("{noop}password").roles("USER")
////                .and()
////                .withUser("admin").password("{noop}password").roles("ADMIN");
////                .withUser("admin").password("{noop}password").roles("USER", "ADMIN");
//
//    }
//
//    // Secure the endpoins with HTTP Basic authentication
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
////HTTP Basic authentication
////        http
////                .httpBasic()
////                .and()
////                .authorizeRequests()
////                .antMatchers(HttpMethod.GET, "/echo/**").hasRole("USER")
////                .antMatchers(HttpMethod.POST, "/srv").hasRole("ADMIN")
////                .and()
////                .csrf().disable()
////                .formLogin().disable();
//
////        http
////                .httpBasic()
////                .and()
////                .authorizeRequests()
////                .anyRequest()
////                .authenticated()
////                .and()
////                .csrf().disable()
////                .formLogin().disable();
//
////        http
////                .authorizeRequests()
////                .anyRequest()
////                .permitAll()
////                .and()
////                .csrf().disable()
////                .formLogin().disable();
//
//
//        http
//                .authorizeRequests()
//                .anyRequest()
//                .authenticated()
//                .and()
//                .csrf().disable()
//                .formLogin().disable();
//    }
//
//    @Autowired
//    private MyUserDetailService userDetailsService;
//
//    @Bean
//    public AuthenticationManager authenticationManager() {
//        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
//        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
//        List<AuthenticationProvider>  list = new ArrayList<>();
//        list.add(daoAuthenticationProvider);
//        return new ProviderManager(list);
//    }
//
////    @Bean
////    public UserDetailsService userDetailsService() {
////        return new MyUserDetailService();
////    }
//}