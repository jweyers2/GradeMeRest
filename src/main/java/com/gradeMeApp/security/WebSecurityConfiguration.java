//package com.gradeMeApp.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Component;
//
//import com.gradeMeApp.service.User.DefaultUserService;
//
//@Component
//@EnableWebSecurity
//public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter{
//
//    @Autowired
//    DefaultUserService UserService;
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.UserDetailsService(UserService).passwordEncoder(new BCryptPasswordEncoder());
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .anyRequest().authenticated()
//                .and()
//                .httpBasic()
//                .and()
//                .csrf().disable();
////        
////     // protect all resources
////     		http.authorizeRequests().anyRequest().fullyAuthenticated();
////     		// protect with http basic authentication
////     		http.httpBasic();
////     		http.csrf().disable();
//    }
//}
