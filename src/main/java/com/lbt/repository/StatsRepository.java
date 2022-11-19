/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.lbt.repository;

import java.util.Date;
import java.util.List;

/**
 *
 * @author DELL
 */
public interface StatsRepository {
//    Thong ke doanh thu tuyen xe theo thang 
    List<Object []> statsDoanhThuTXByMonth(String diemDi, String diemDen, Date fromDate, Date toDate);
    List<Object []> statsDoanhThuTXByYear(String diemDi, String diemDen, Date fromDate, Date toDate);
}
