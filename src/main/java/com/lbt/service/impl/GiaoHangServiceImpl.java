/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lbt.service.impl;

import com.lbt.pojos.ChuyenXe;
import com.lbt.pojos.DonDatHang;
import com.lbt.pojos.User;
import com.lbt.repository.ChuyenXeRepository;
import com.lbt.repository.GiaoHangRepository;
import com.lbt.service.GiaoHangService;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DELL
 */
@Service
public class GiaoHangServiceImpl implements GiaoHangService {
    @Autowired
    private GiaoHangRepository giaoHangRepository;
    
    @Autowired
    private ChuyenXeRepository chuyenXeRepository;

    @Override
    public DonDatHang giaoHang(String tenNguoiGui, String phoneNguoiGui, String emailNguoiGui, 
            String tenNguoiNhan, String phoneNguoiNhan, String emailNguoiNhan, String moTa, int soKi, Long gia, int chuyenXeID, User creator) {
        DonDatHang ddh = new DonDatHang();
        
        ChuyenXe cx = this.chuyenXeRepository.getChuyenXeByID(chuyenXeID);
        ddh.setNguoiGui(tenNguoiGui);
        ddh.setSdtNguoiGui(phoneNguoiGui);
        ddh.setEmailNguoiGui(emailNguoiGui);
        ddh.setNguoiNhan(tenNguoiNhan);
        ddh.setEmailNguoiNhan(emailNguoiNhan);
        ddh.setSdtNguoiNhan(phoneNguoiNhan);
        ddh.setThoiGianGui(new Date());
        ddh.setThoiGianNhan(new Date());
        ddh.setLoaiMatHang(moTa);
        ddh.setSoKi(soKi);
        ddh.setDonGia(gia);
        ddh.setChuyenXeId(cx);
        ddh.setUserId(creator);
        
        return this.giaoHangRepository.giaoHang(ddh);
    }
    
}
