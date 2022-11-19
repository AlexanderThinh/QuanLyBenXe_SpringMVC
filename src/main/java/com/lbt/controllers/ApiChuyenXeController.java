/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lbt.controllers;

import com.lbt.pojos.ChuyenXe;
import com.lbt.pojos.LoaiXe;
import com.lbt.pojos.NhaXe;
import com.lbt.pojos.TuyenXe;
import com.lbt.service.ChuyenXeService;
import com.lbt.service.LoaiXeService;
import com.lbt.service.NhaXeService;
import com.lbt.service.TuyenXeService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
public class ApiChuyenXeController {
    @Autowired
    private ChuyenXeService chuyenXeService;
    
    @Autowired
    private LoaiXeService loaiXeService;
    
    @Autowired
    private TuyenXeService tuyenXeService;
    
    @Autowired
    private NhaXeService nhaXeService;
    
    @PostMapping(path="/add-chuyen-xe", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ChuyenXe> addChuyenXe(@RequestBody Map<String, String> params) {
        try {
            String bienSo = params.get("bienSo");
            int soGhe = Integer.parseInt(params.get("soGhe"));
            Long gia = Long.parseLong(params.get("gia"));
            String dichVu = params.get("dichVu");
            String gioXeChay = params.get("gioXeChay");
            
            SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        
            Date ngayDi = null, ngayVe = null;
            
            try {
                String paramNgayDi = params.getOrDefault("ngayDi", null);
                if(paramNgayDi != null) {
                    ngayDi = f.parse(paramNgayDi);
                }

                String paramNgayVe = params.getOrDefault("ngayVe", null);
                if(paramNgayVe != null) {
                    ngayVe = f.parse(paramNgayVe);
                }
            } catch (ParseException ex) {
                ex.printStackTrace();
            }
            
            int loaiXeID = Integer.parseInt(params.get("loaiXeID"));
            LoaiXe lx = this.loaiXeService.getLoaiXeByID(loaiXeID);
            
            int nhaXeID = Integer.parseInt(params.get("nhaXeID"));
            NhaXe nx = this.nhaXeService.getNhaXeByID(nhaXeID);
            
            int tuyenXeID = Integer.parseInt(params.get("tuyenXeID"));
            TuyenXe tx = this.tuyenXeService.getTuyeXeByID(tuyenXeID);
            
            this.chuyenXeService.addChuyenXe(bienSo, soGhe, gia, dichVu, lx, nx, tx, ngayDi, ngayVe, gioXeChay);
            
            return new ResponseEntity<>(HttpStatus.CREATED);
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    
}
