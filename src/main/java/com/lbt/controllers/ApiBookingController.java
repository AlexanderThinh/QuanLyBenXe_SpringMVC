/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lbt.controllers;

import com.lbt.pojos.DonDatVe;
import com.lbt.pojos.User;
import com.lbt.service.BookingService;
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
public class ApiBookingController {
    @Autowired
    private BookingService bookingService;
    
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
    
    @PostMapping(path = "/booking/{chuyenXeID}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<DonDatVe> booking(@RequestBody Map<String, String> params,
            HttpSession session, @PathVariable(value = "chuyenXeID") int chuyenXeID) {
        User currentUser = (User) session.getAttribute("currentUser");
//        User currentUser = this.userService.getUserByID(7);
        
        if(currentUser != null) {
            try {
                Long gia = Long.parseLong(params.get("gia"));
                int soGhe = Integer.parseInt(params.get("soGhe"));
                int loaiVeID = Integer.parseInt(params.get("loaiVeID"));
                
                DonDatVe ddv = this.bookingService.booking(gia, soGhe, chuyenXeID, loaiVeID, currentUser);
                
                String receipient = params.get("receipient");
                String subject = params.get("subject");
                String content = params.get("content");
                sendEmail("1954032326thinh@ou.edu.vn", receipient, subject, content);
                
                return new ResponseEntity<>(ddv, HttpStatus.CREATED);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
