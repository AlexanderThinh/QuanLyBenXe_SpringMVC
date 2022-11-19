/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lbt.service.impl;

import com.lbt.pojos.BenXe;
import com.lbt.pojos.NhaXe;
import com.lbt.repository.BenXeRepository;
import com.lbt.repository.NhaXeRepository;
import com.lbt.service.NhaXeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DELL
 */
@Service
public class NhaXeServiceImpl implements NhaXeService{
    @Autowired
    private NhaXeRepository nhaXeRepository;
    
    @Autowired
    private BenXeRepository benXeRepository;

    @Override
    public List<NhaXe> getAllNhaXe(int isActive) {
        return this.nhaXeRepository.getAllNhaXe(isActive);
    }

    @Override
    public NhaXe getNhaXeByID(int nhaXeID) {
        return this.nhaXeRepository.getNhaXeByID(nhaXeID);
    }

    @Override
    public NhaXe addNhaXe(String tenNhaXe, int benXeID, boolean nhanGiaoHang) {
        BenXe bx = this.benXeRepository.getBenXeByID(benXeID);
        
        NhaXe nx = new NhaXe();
        nx.setTenNhaXe(tenNhaXe);
        nx.setBenXeId(bx);
        nx.setActive(Boolean.FALSE);
        nx.setGiaoHang(nhanGiaoHang);
        
        return this.nhaXeRepository.addNhaXe(nx);
    }

    @Override
    public boolean updateActiveNhaXe(int nhaXeID) {
        NhaXe nx = this.nhaXeRepository.getNhaXeByID(nhaXeID);
        
        return this.nhaXeRepository.updateActiveNhaXe(nx);
    }
    
}
