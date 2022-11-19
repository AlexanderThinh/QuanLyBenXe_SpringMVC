/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lbt.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.lbt.pojos.TuyenXe;
import com.lbt.repository.TuyenXeRepository;
import com.lbt.service.TuyenXeService;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DELL
 */
@Service
public class TuyenXeServiceImpl implements TuyenXeService{
    @Autowired
    private TuyenXeRepository tuyenXeRepository;
    
    @Autowired
    private Cloudinary cloudinary;

    @Override
    public List<TuyenXe> getAllTuyenXe() {
        return this.tuyenXeRepository.getAllTuyenXe();
    }

    @Override
    public List<Object []> getTopTuyenXe(int topNumber) {
        return this.tuyenXeRepository.getTopTuyenXe(topNumber);
    }

    @Override
    public TuyenXe getTuyeXeByID(int tuyenXeID) {
        return this.tuyenXeRepository.getTuyeXeByID(tuyenXeID);
    }

    @Override
    public boolean addTuyenXe(TuyenXe tx) {
        try {
            Map response = this.cloudinary.uploader().upload(tx.getFile().getBytes(),
                    ObjectUtils.asMap("resource_type", "auto"));
//            Lay duong dan anh tren cloudinary response sau khi upload thanh cong            
            String img =  (String) response.get("secure_url");
        
            tx.setImage(img);
            
            return this.tuyenXeRepository.addTuyenXe(tx);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        return false;
    }
    
}
