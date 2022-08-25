/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.lbt.service;

import com.lbt.pojos.DonDatHang;
import com.lbt.pojos.User;

/**
 *
 * @author DELL
 */
public interface GiaoHangService {
    DonDatHang giaoHang(String tenNguoiGui, String phoneNguoiGui, String emailNguoiGui,
            String tenNguoiNhan, String phoneNguoiNhan, String emailNguoiNhan,
            String moTa, int soKi, Long gia, int chuyenXeID, User creator);
}
