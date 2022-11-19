/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lbt.service.impl;

import com.lbt.pojos.ChuyenXe;
import com.lbt.pojos.DonDatVe;
import com.lbt.pojos.LoaiVe;
import com.lbt.pojos.User;
import com.lbt.repository.BookingRepository;
import com.lbt.repository.ChuyenXeRepository;
import com.lbt.repository.LoaiVeRepository;
import com.lbt.service.BookingService;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DELL
 */
@Service
public class BookingServiceImpl implements BookingService {
    @Autowired
    private BookingRepository bookingRepository; 
    
    @Autowired
    private ChuyenXeRepository chuyenXeRepository; 
    
    @Autowired
    private LoaiVeRepository loaiVeRepository;

    @Override
    public DonDatVe booking(Long gia, int soGhe, int chuyenXeID, int loaiVeID, User creator) {
        DonDatVe ddv = new DonDatVe();
        
        ChuyenXe cx = this.chuyenXeRepository.getChuyenXeByID(chuyenXeID);
        LoaiVe lv = this.loaiVeRepository.getLoaiVeByID(loaiVeID);
        
        ddv.setGia(gia);
        ddv.setCreatedDate(new Date());
        ddv.setSoGhe(soGhe);
        ddv.setUserId(creator);
        ddv.setChuyenXeId(cx);
        ddv.setLoaiVeId(lv);
        
        return this.bookingRepository.booking(ddv);
    }
    
}
