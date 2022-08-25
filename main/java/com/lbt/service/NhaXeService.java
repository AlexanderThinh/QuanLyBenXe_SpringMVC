/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.lbt.service;

import com.lbt.pojos.NhaXe;
import java.util.List;

/**
 *
 * @author DELL
 */
public interface NhaXeService {
    List<NhaXe> getAllNhaXe(int isActive);
    NhaXe getNhaXeByID(int nhaXeID);
    NhaXe addNhaXe(String tenNhaXe, int benXeID, boolean nhanGiaoHang);
    boolean updateActiveNhaXe(int nhaXeID);
}
