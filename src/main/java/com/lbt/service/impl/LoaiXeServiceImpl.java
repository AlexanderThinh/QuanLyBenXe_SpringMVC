/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lbt.service.impl;

import com.lbt.pojos.LoaiXe;
import com.lbt.repository.LoaiXeRepository;
import com.lbt.service.LoaiXeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DELL
 */
@Service
public class LoaiXeServiceImpl implements LoaiXeService {
    @Autowired
    private LoaiXeRepository loaiXeRepository;

    @Override
    public LoaiXe getLoaiXeByID(int loaiXeID) {
        return this.loaiXeRepository.getLoaiXeByID(loaiXeID);
    }

    @Override
    public List<LoaiXe> getAllLoaiXe() {
        return this.loaiXeRepository.getAllLoaiXe();
    }
    
    
}
