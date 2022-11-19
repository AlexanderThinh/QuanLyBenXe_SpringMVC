/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lbt.service.impl;

import com.lbt.pojos.BenXe;
import com.lbt.repository.BenXeRepository;
import com.lbt.service.BenXeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DELL
 */
@Service
public class BenXeServiceImpl implements BenXeService {
    @Autowired
    private BenXeRepository benXeRepository;

    @Override
    public List<BenXe> getDSBenXe() {
        return this.benXeRepository.getDSBenXe();
    }

    @Override
    public BenXe getBenXeByID(int benXeID) {
        return this.benXeRepository.getBenXeByID(benXeID);
    }
    
}
