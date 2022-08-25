/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lbt.service.impl;

import com.lbt.pojos.NhaXe;
import com.lbt.pojos.Rating;
import com.lbt.pojos.User;
import com.lbt.repository.NhaXeRepository;
import com.lbt.repository.RatingRepository;
import com.lbt.service.RatingService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DELL
 */
@Service
public class RatingServiceImpl implements RatingService {
    @Autowired
    private RatingRepository ratingRepository;
    
    @Autowired
    private NhaXeRepository nhaXeRepository;

    @Override
    public List<Rating> getRatingByUserAndNhaXe(int userID, int nhaXeID) {
        return this.ratingRepository.getRatingByUserAndNhaXe(userID, nhaXeID);
    }

    @Override
    public boolean ratingNhaXe(Rating r) {
        return this.ratingRepository.ratingNhaXe(r);
    }
}
