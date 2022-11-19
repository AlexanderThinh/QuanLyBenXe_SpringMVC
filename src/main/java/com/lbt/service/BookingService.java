/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.lbt.service;

import com.lbt.pojos.DonDatVe;
import com.lbt.pojos.User;

/**
 *
 * @author DELL
 */
public interface BookingService {
    DonDatVe booking(Long gia, int soGhe, int chuyenXeID, int loaiVeID, User creator);
}
