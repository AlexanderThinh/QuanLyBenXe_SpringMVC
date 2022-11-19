/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lbt.controllers;

import com.lbt.pojos.TuyenXe;
import com.lbt.service.TuyenXeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author DELL
 */
@Controller
public class TuyenXeController {
    @Autowired
    private TuyenXeService tuyenXeService;
    
    @GetMapping("tuyen-xe/{tuyenXeID}")
    public String tuyenXeDetail(Model model, @PathVariable(value = "tuyenXeID") int tuyenXeID) {
        model.addAttribute("tuyenXe", this.tuyenXeService.getTuyeXeByID(tuyenXeID));
        model.addAttribute("tuyenXeID", tuyenXeID);
        
        return "tuyenXeDetail";
    }
    
    @GetMapping("/tuyen-xe/create")
    public String renderViewAddTuyenXe(Model model) {
        TuyenXe tx = new TuyenXe();
        model.addAttribute("tuyenXe", tx);
        
        return "nxThemTuyenXe";
    }
    
    @PostMapping("/tuyen-xe/create")
    public String addTuyenXe(Model model, @ModelAttribute(value = "tuyenXe") TuyenXe tx) {
        if(this.tuyenXeService.addTuyenXe(tx) == true) {
            return "redirect:/chuyen-xe/create";
        } else {
            model.addAttribute("errMsg", "Something went wrong!");
        }
        
        return "nxThemTuyenXe";
    }
}
