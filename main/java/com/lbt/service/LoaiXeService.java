/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.lbt.service;

import com.lbt.pojos.LoaiXe;
import java.util.List;

/**
 *
 * @author DELL
 */
public interface LoaiXeService {
    LoaiXe getLoaiXeByID(int loaiXeID);
    List<LoaiXe> getAllLoaiXe();
}
