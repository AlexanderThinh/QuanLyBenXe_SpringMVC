/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lbt.controllers;

import com.lbt.service.ChuyenXeService;
import com.lbt.service.LoaiXeService;
import com.lbt.service.NhaXeService;
import com.lbt.service.TuyenXeService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author DELL
 */
@Controller
public class ChuyenXeController {
    @Autowired
    private LoaiXeService loaiXeService;
    
    @Autowired
    private TuyenXeService tuyenXeService;
    
    @Autowired
    private ChuyenXeService chuyenXeService;
    
    @Autowired
    private NhaXeService nhaXeService;
    
    @GetMapping("/chuyen-xe/create")
    public String addChuyenXe(Model model) {
        model.addAttribute("DSTuyenXe", this.tuyenXeService.getAllTuyenXe());
        model.addAttribute("DSNhaXe", this.nhaXeService.getAllNhaXe(1));
        model.addAttribute("DSLoaiXe", this.loaiXeService.getAllLoaiXe());
        
        return "nxThemChuyenXe";
    }
    
    @GetMapping("/chuyen-xe/list")
    public String getDSChuyenXe(Model model, @RequestParam Map<String, String> params) {
        String diemDi = params.getOrDefault("diem-di", null);
        String diemDen = params.getOrDefault("diem-den", null);
        
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        Date ngayDi = null;
        try {
            String paramNgayDi = params.getOrDefault("ngay-di", null);
            if(paramNgayDi != null) {
                ngayDi = f.parse(paramNgayDi);
            }
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        
        model.addAttribute("listChuyenXe" ,this.chuyenXeService.getDSChuyenXe(0, false, diemDi, diemDen, ngayDi, 0));
        
        return "listChuyenXeCommon";
    }
}
