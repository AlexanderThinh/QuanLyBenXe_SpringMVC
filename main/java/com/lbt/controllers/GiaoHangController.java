/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lbt.controllers;

import com.lbt.service.BenXeService;
import com.lbt.service.ChuyenXeService;
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
public class GiaoHangController {
    @Autowired
    private BenXeService benXeService; 
    
    @Autowired
    private ChuyenXeService chuyenXeService;
    
    @GetMapping("/giao-hang")
    public String GiaoHang(Model model, @RequestParam Map<String, String> params) {
        model.addAttribute("DSBenXe", this.benXeService.getDSBenXe());
        
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
        
        model.addAttribute("listChuyenXe" ,this.chuyenXeService.getDSChuyenXe(0, true, diemDi, diemDen, ngayDi, 0));
        
        return "giaoHang";
    }
}
