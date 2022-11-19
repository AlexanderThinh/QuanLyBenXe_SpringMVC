/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.lbt.service;

import com.lbt.pojos.ChuyenXe;
import com.lbt.pojos.LoaiXe;
import com.lbt.pojos.NhaXe;
import com.lbt.pojos.TuyenXe;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author DELL
 */
public interface ChuyenXeService {
    List<ChuyenXe> getDSChuyenXe(int nhaXeID, boolean giaoHang, String diemDi, String diemDen, Date ngayDi, int page);
    boolean addChuyenXe(String bienSo, int soGhe, Long gia, String dichVu, 
            LoaiXe loaiXe, NhaXe nx, TuyenXe tx, Date ngayDi, Date ngayVe, String gioXeChay);
    ChuyenXe getChuyenXeByID(int ID);
}
