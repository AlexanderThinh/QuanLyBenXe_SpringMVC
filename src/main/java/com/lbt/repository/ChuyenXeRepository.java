/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.lbt.repository;

import com.lbt.pojos.ChuyenXe;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author DELL
 */
public interface ChuyenXeRepository {
    List<ChuyenXe> getDSChuyenXe(int nhaXeID, boolean giaoHang, String diemDi, String diemDen, Date ngayDi, int page);
    boolean addChuyenXe(ChuyenXe cx);
    ChuyenXe getChuyenXeByID(int ID);
}
