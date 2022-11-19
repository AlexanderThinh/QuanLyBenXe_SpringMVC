/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lbt.controllers;

import com.lbt.pojos.DonDatHang;
import com.lbt.pojos.User;
import com.lbt.service.GiaoHangService;
import com.lbt.service.UserService;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author DELL
 */
@Controller 
@RequestMapping("/api")
public class ApiGiaoHangController {
    @Autowired
    private UserService userService;
    
    @Autowired
    private GiaoHangService giaoHangService;
    
    @Autowired
    private MailSender mailSender;
    
    public void sendEmail(String from, String to, String subject, String content) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(from);
        mailMessage.setTo(to);
        mailMessage.setSubject(subject);
        mailMessage.setText(content);
        
        mailSender.send(mailMessage);
    }
    
    @PostMapping(path="/giao-hang/{chuyenXeID}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<DonDatHang> giaoHang(@RequestBody Map<String, String> params,
            HttpSession session, @PathVariable(value = "chuyenXeID") int chuyenXeID) {
        User currentUser = (User) session.getAttribute("currentUser");
//        User currentUser = this.userService.getUserByID(7);
        
        if(currentUser != null) {
            try {
                String tenNguoiGui = params.get("ten-nguoi-gui");
                String phoneNguoiGui = params.get("phone-nguoi-gui");
                String emailNguoiGui = params.get("email-nguoi-gui");
                String tenNguoiNhan = params.get("ten-nguoi-nhan");
                String phoneNguoiNhan = params.get("phone-nguoi-nhan");
                String emailNguoiNhan = params.get("email-nguoi-nhan");
                String moTa = params.get("mo-ta");
                int soKi = Integer.parseInt(params.get("so-ki"));
                Long gia = Long.parseLong(params.get("gia"));
                
                String contentEmail = params.get("contentEmail");
                
                DonDatHang ddh = this.giaoHangService.giaoHang(tenNguoiGui, phoneNguoiGui, emailNguoiGui, 
                        tenNguoiNhan, phoneNguoiNhan, emailNguoiNhan, moTa, soKi, gia, chuyenXeID, currentUser);
                
                sendEmail("1954032326thinh@ou.edu.vn", emailNguoiNhan, "THONG TIN DANG KY GIAO HANG", contentEmail);
                
                return new ResponseEntity<>(ddh, HttpStatus.CREATED);
                
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
