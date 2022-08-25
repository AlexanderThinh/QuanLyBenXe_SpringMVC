/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lbt.configs.handlers;

import com.lbt.pojos.User;
import com.lbt.service.UserService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

/**
 *
 * @author DELL
 */
@Component
public class LoginHandler implements AuthenticationSuccessHandler {
    @Autowired
    private UserService userDetailsService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication auth) throws IOException, ServletException {
//        Luu doi tuong user vao session truoc khi chuyen ve trang chu ("/")
        User u = this.userDetailsService.getUsers(auth.getName()).get(0);
        request.getSession().setAttribute("currentUser", u);
        
        
        response.sendRedirect("/QuanLyBenXeKhach");
    }
    
}
