/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lbt.controllers;

import com.lbt.pojos.NhaXe;
import com.lbt.pojos.Rating;
import com.lbt.pojos.User;
import com.lbt.service.NhaXeService;
import com.lbt.service.RatingService;
import com.lbt.service.UserService;
import java.util.Date;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author DELL
 */
@RestController
@RequestMapping("/api")
public class ApiRatingController {
    @Autowired
    private RatingService ratingService;
    
    @Autowired
    private NhaXeService nhaXeService;
    
    @Autowired
    private UserService userService;
    
    @PostMapping(path="/nha-xe/rating/{nhaXeID}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Rating> ratingNhaXe(@PathVariable(value = "nhaXeID") int nhaXeID,
            @RequestBody Map<String, String> params, HttpSession session) {
        try {
            int rate = Integer.parseInt(params.get("rate"));
            User currentUser = (User) session.getAttribute("currentUser");
            int userID = currentUser.getId();
            NhaXe nx = this.nhaXeService.getNhaXeByID(nhaXeID);

            if(this.ratingService.getRatingByUserAndNhaXe(userID, nhaXeID).size() == 0) {
                Rating r1 = new Rating();
                
                r1.setRate(rate);
                r1.setCreatedDate(new Date());
                r1.setUpdatedDate(new Date());
                r1.setNhaXeId(nx);
                r1.setUserId(currentUser);
                
                this.ratingService.ratingNhaXe(r1);
            } else {
                Rating r2 = this.ratingService.getRatingByUserAndNhaXe(userID, nhaXeID).get(0);
                r2.setRate(rate);
                r2.setUpdatedDate(new Date());
                
                this.ratingService.ratingNhaXe(r2);
            }
            
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    
}
