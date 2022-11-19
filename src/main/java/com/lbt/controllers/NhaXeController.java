/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lbt.controllers;

import com.lbt.pojos.NhaXe;
import com.lbt.pojos.Rating;
import com.lbt.pojos.User;
import com.lbt.service.BenXeService;
import com.lbt.service.ChuyenXeService;
import com.lbt.service.NhaXeService;
import com.lbt.service.RatingService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author DELL
 */
@Controller
public class NhaXeController {
    @Autowired
    private NhaXeService nhaXeService;
    
    @Autowired
    private ChuyenXeService chuyenXeService;
    
    @Autowired
    private BenXeService benXeService;
    
    @Autowired
    private RatingService ratingService;
    
    @GetMapping("/nha-xe/{nhaXeID}")
    public String DSChuyenXeByNhaXe(Model model, HttpSession session,
            @RequestParam(required = false) Map<String, String> params,
            @PathVariable(value = "nhaXeID") int nhaXeID) {
        
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");       
        Date ngayDi = null;
        
        String diemDi = params.getOrDefault("diem-di", null);
        String diemDen = params.getOrDefault("diem-den", null);
      
        try {
            String paramsNgayDi = params.getOrDefault("ngay-di", null);
            if(paramsNgayDi != null) {
                ngayDi = f.parse(paramsNgayDi);
            }
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        
//        Get doi tuong rating theo nha xe va user dang dang nhap
        User currentUser = (User) session.getAttribute("currentUser");
        if (currentUser != null) {
            int currentUserID = currentUser.getId();
            List<Rating> rates = this.ratingService.getRatingByUserAndNhaXe(currentUserID, nhaXeID);
            model.addAttribute("rateListLength", rates.size());
            if(rates.size() > 0) {
                Rating rate = rates.get(0);
                model.addAttribute("rate", rate);
                model.addAttribute("currentUser", currentUser);
            }
        }
        
        model.addAttribute("valueForStopLoop", 1);
        
        model.addAttribute("DSChuyenXe", this.chuyenXeService.getDSChuyenXe(nhaXeID, false, diemDi, diemDen, ngayDi, 0));
        model.addAttribute("nhaXe", this.nhaXeService.getNhaXeByID(nhaXeID));
        model.addAttribute("nhaXeID", nhaXeID);
        
        model.addAttribute("othersChuyenXe", this.chuyenXeService.getDSChuyenXe(0, false, diemDi, diemDen, ngayDi, 0));
        
        return "listChuyenXe";
    }
    
    @GetMapping("/nx/them-nha-xe")
    public String addNhaXe(Model model) {
        model.addAttribute("nhaXe", new NhaXe());
        model.addAttribute("DSBenXe", this.benXeService.getDSBenXe());
        
        return "adminThemNhaXe";
    }
}
