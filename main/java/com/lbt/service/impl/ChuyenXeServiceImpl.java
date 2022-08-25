/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lbt.service.impl;

import com.lbt.pojos.ChuyenXe;
import com.lbt.pojos.LoaiXe;
import com.lbt.pojos.NhaXe;
import com.lbt.pojos.TuyenXe;
import com.lbt.repository.ChuyenXeRepository;
import com.lbt.repository.LoaiXeRepository;
import com.lbt.repository.TuyenXeRepository;
import com.lbt.service.ChuyenXeService;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DELL
 */
@Service
public class ChuyenXeServiceImpl implements ChuyenXeService{
    @Autowired
    private ChuyenXeRepository chuyenXeRepository;
    
    @Autowired
    private LoaiXeRepository loaiXeRepository;
    
    @Autowired
    private TuyenXeRepository tuyenXeRepository;

    @Override
    public List<ChuyenXe> getDSChuyenXe(int nhaXeID, boolean giaoHang, String diemDi, String diemDen, Date ngayDi, int page) {
        return this.chuyenXeRepository.getDSChuyenXe(nhaXeID, giaoHang, diemDi, diemDen, ngayDi, page);
    }

    @Override
    public boolean addChuyenXe(String bienSo, int soGhe, Long gia, 
            String dichVu, LoaiXe loaixe, NhaXe nhaxe, TuyenXe tx, Date ngayDi, Date ngayVe) {
        ChuyenXe cx = new ChuyenXe();
        
        cx.setBienSo(bienSo);
        cx.setNgayDi(ngayDi);
        cx.setNgayVe(ngayVe);
        cx.setSoGhe(soGhe);
        cx.setGia(gia);
        cx.setDichVu(dichVu);
        cx.setLoaiXeId(loaixe);
        cx.setNhaXeId(nhaxe);
        cx.setTuyenXeId(tx);
        
        return this.chuyenXeRepository.addChuyenXe(cx);
    }

    @Override
    public ChuyenXe getChuyenXeByID(int ID) {
        return this.chuyenXeRepository.getChuyenXeByID(ID);
    }
    
}
