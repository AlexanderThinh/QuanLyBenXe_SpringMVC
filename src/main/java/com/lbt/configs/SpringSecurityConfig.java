/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lbt.configs;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.lbt.configs.handlers.LoginHandler;
import com.lbt.configs.handlers.LogoutHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author DELL
 */
@Configuration
@EnableWebSecurity
@EnableTransactionManagement
@ComponentScan(basePackages = {
    "com.lbt.repository",
    "com.lbt.service"   
})
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService userDetailsService;
    
    @Autowired
    private AuthenticationSuccessHandler loginSuccessHandler;
    
    @Autowired
    private LogoutSuccessHandler logoutHandler;
    
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    public AuthenticationSuccessHandler loginSuccessHandler() {
        return new LoginHandler();
    }
  
    @Bean
    public LogoutSuccessHandler logoutHandler() {
        return new LogoutHandler();
    }
    
    @Bean
    public Cloudinary cloudinary() {
        Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
        "cloud_name", "dk2yfgnb4",
        "api_key", "887277283414279",
        "api_secret", "yoCP6RXis5TnNlKDY2nf1kRjcA4",
        "secure", true
    ));
        
        return cloudinary;
    }
    
//    Cung cap TT chung thuc
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }  
    
//    Cung cap TT phan quyen user
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        Login
        http.formLogin().loginPage("/login")
                .usernameParameter("username").passwordParameter("password");   
        http.formLogin().defaultSuccessUrl("/").failureUrl("/login?error");
        http.formLogin().successHandler(this.loginSuccessHandler);

//        Logout
//        http.logout().logoutSuccessUrl("/login");
        http.logout().logoutSuccessHandler(this.logoutHandler);

//        Xu ly tu choi dang nhap 
        http.exceptionHandling().accessDeniedPage("/login?accessDenied");
        http.authorizeRequests().antMatchers("/").permitAll()
            .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
            .antMatchers("/nx/**").access("hasRole('ROLE_NHA_XE')");

        http.csrf().disable();
    }    
}
