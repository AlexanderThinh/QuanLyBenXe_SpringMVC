/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.lbt.service;

import com.lbt.pojos.Rating;
import com.lbt.pojos.User;
import java.util.List;

/**
 *
 * @author DELL
 */
public interface RatingService {
    List<Rating> getRatingByUserAndNhaXe(int userID, int nhaXeID);
    boolean ratingNhaXe(Rating r);
}
