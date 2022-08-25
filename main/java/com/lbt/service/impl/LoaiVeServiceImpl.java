/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lbt.service.impl;

import com.lbt.pojos.LoaiVe;
import com.lbt.repository.LoaiVeRepository;
import com.lbt.service.LoaiVeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DELL
 */
@Service
public class LoaiVeServiceImpl implements LoaiVeService {
    @Autowired
    private LoaiVeRepository loaiVeRepository;

    @Override
    public LoaiVe getLoaiVeByID(int ID) {
        return this.loaiVeRepository.getLoaiVeByID(ID);
    }
    
}
