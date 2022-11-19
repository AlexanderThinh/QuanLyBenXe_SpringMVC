/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lbt.controllers;

import com.lbt.pojos.NhaXe;
import com.lbt.service.BenXeService;
import com.lbt.service.StatsService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author DELL
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private StatsService statsService;
    
    @Autowired
    private BenXeService benXeService;
    
    @GetMapping("/them-nha-xe")
    public String showAdminThemNhaXe(Model model) {
        model.addAttribute("nhaXe", new NhaXe());
        model.addAttribute("DSBenXe", this.benXeService.getDSBenXe());
        
        return "adminThemNhaXe";
    }
    
    @GetMapping("/quan-ly-nha-xe")
    public String quanLyNhaXe(Model model) {
        
        return "adminQuanLyNhaXe";
    }
    
//    Thong ke doanh thu tuyen xe theo thang va quy trong nam
    @GetMapping("/doanh-thu-stats")
    public String doanhThuStats(Model model,
            @RequestParam(required = false) Map<String, String> params) {
        String diemDi = params.getOrDefault("diemDi", null);
        String diemDen = params.getOrDefault("diemDen", null);
        
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        
        Date fromDate = null, toDate = null;
        try {
            String paramFromDate = params.getOrDefault("fromDate", null);
            if(paramFromDate != null) {
                fromDate = f.parse(paramFromDate);
            }

            String paramToDate = params.getOrDefault("toDate", null);
            if(paramToDate != null) {
                toDate = f.parse(paramToDate);
            }
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        
        model.addAttribute("doanhThuStats", this.statsService.statsDoanhThuTXByMonth(diemDi, diemDen, fromDate, toDate));
        
        return "adminDoanhThuStats";
    }
    
//    Thong ke doanh thu tuyen xe theo thang va quy trong nam
    @GetMapping("/doanh-thu-stats-by-year")
    public String doanhThuStatsByYear(Model model,
            @RequestParam(required = false) Map<String, String> params) {
        String diemDi = params.getOrDefault("diemDi", null);
        String diemDen = params.getOrDefault("diemDen", null);
        
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        
        Date fromDate = null, toDate = null;
        try {
            String paramFromDate = params.getOrDefault("fromDate", null);
            if(paramFromDate != null) {
                fromDate = f.parse(paramFromDate);
            }

            String paramToDate = params.getOrDefault("toDate", null);
            if(paramToDate != null) {
                toDate = f.parse(paramToDate);
            }
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        
        model.addAttribute("doanhThuStatsByYear", this.statsService.statsDoanhThuTXByYear(diemDi, diemDen, fromDate, toDate));
        
        return "adminDoanhThuStatsByYear";
    }    
}
