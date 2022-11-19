/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lbt.controllers;

import com.lbt.pojos.TuyenXe;
import com.lbt.service.TuyenXeService;
import java.util.List;
import java.util.Map;
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
public class ApiTuyenXeController {
    @Autowired
    private TuyenXeService tuyenXeService;
    
//    Api Lay all tuyen xe
    @GetMapping("/get-all-tuyen-xe")
    public ResponseEntity<List<TuyenXe>> getAllTuyenXe() {
        return new ResponseEntity<>(this.tuyenXeService.getAllTuyenXe(), HttpStatus.OK);
    }
    
//    Api Lay top tuyen xe pho bien nhat 
    @GetMapping("/get-top-tuyen-xe")
    public ResponseEntity<List<Object []>> getTopTuyenXe() {
        return new ResponseEntity<>(this.tuyenXeService.getTopTuyenXe(8), HttpStatus.OK);
    }
    
    @GetMapping(path = "/get-tuyen-xe/{tuyenXeID}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<TuyenXe> getTuyenXeByID(@PathVariable(value = "tuyenXeID") int tuyenXeID) {
        TuyenXe tx = this.tuyenXeService.getTuyeXeByID(tuyenXeID);
        
        return new ResponseEntity<>(tx, HttpStatus.OK);
    }
}
