/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lbt.controllers;

import com.lbt.pojos.BenXe;
import com.lbt.pojos.NhaXe;
import com.lbt.service.BenXeService;
import com.lbt.service.NhaXeService;
import java.util.List;
import java.util.Map;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
public class ApiNhaXeController {    
    @Autowired
    private NhaXeService nhaXeService;
    
    @GetMapping("/get-all-nha-xe")
    public ResponseEntity<List<NhaXe>> getAllNhaXe() {
        return new ResponseEntity<>(this.nhaXeService.getAllNhaXe(0), HttpStatus.OK);
    }
    
    @PostMapping(path="/add-nha-xe", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<NhaXe> addNhaXe(@RequestBody Map<String, String> params) {
        try {
            String tenNhaXe = params.get("tenNhaXe");
            int benXeID = Integer.parseInt(params.get("benXeID"));
            int nhanGiaoHang = Integer.parseInt(params.get("nhanGiaoHang"));
            
            boolean giaoHang = false;
            if (nhanGiaoHang == 1) {
                giaoHang = true;
            }
            
            NhaXe nx = this.nhaXeService.addNhaXe(tenNhaXe, benXeID, giaoHang);
            
            return new ResponseEntity<>(nx, HttpStatus.CREATED);
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    
    @PostMapping(path="/update-active-nha-xe/{nhaXeID}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<NhaXe> updateActiveNhaXe(@PathVariable(value = "nhaXeID") int nhaXeID) {
        try {
            this.nhaXeService.updateActiveNhaXe(nhaXeID);
            
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
