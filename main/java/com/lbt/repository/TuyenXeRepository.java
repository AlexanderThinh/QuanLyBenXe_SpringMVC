/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.lbt.repository;

import com.lbt.pojos.TuyenXe;
import java.util.List;

/**
 *
 * @author DELL
 */
public interface TuyenXeRepository {
    List<TuyenXe> getAllTuyenXe();
    List<Object []> getTopTuyenXe(int topNumber);
    TuyenXe getTuyeXeByID(int tuyenXeID);
    boolean addTuyenXe(TuyenXe tx);
}
