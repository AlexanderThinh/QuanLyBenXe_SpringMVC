/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.lbt.repository;

import com.lbt.pojos.NhaXe;
import com.lbt.pojos.Rating;
import java.util.List;

/**
 *
 * @author DELL
 */
public interface NhaXeRepository {
    List<NhaXe> getAllNhaXe(int isActive);
    NhaXe getNhaXeByID(int nhaXeID);
    NhaXe addNhaXe(NhaXe nx);
    boolean updateActiveNhaXe(NhaXe nx);
}
