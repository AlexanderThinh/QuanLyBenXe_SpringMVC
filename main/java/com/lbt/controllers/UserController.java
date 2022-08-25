/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lbt.controllers;

import com.lbt.pojos.User;
import com.lbt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author DELL
 */
@Controller
public class UserController {
    @Autowired
    private UserService userDetailsService;
    
    @Autowired
    private MailSender mailSender;
    
    @GetMapping("/login")
    public String login() {
        
        return "login";
    }
    
    @GetMapping("/register")
    public String registerView(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }
    
    @PostMapping("/register")
    public String register(Model model, @ModelAttribute(value = "user") User u) {
        if (u.getPassword().equals(u.getConfirmPassword())) {   
            if (this.userDetailsService.addUser(u) == true) {
                return "redirect:/login";
            } else {
                model.addAttribute("errMsg", "Something went wrong!");
            }
        } else {
            model.addAttribute("errMsg", "Mật khẩu không khớp");
        }
          
        return "register";
    }
    
    public void sendEmail(String from, String to, String subject, String content) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(to);
        mailMessage.setSubject(subject);
        mailMessage.setText(content);
        
        mailSender.send(mailMessage);
    }
}
