/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lbt.service.impl;

import com.lbt.repository.StatsRepository;
import com.lbt.service.StatsService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DELL
 */
@Service
public class StatsServiceImpl implements StatsService {
    @Autowired
    private StatsRepository statsRepository;

    @Override
    public List<Object[]> statsDoanhThuTXByMonth(String diemDi, String diemDen, Date fromDate, Date toDate) {
        return this.statsRepository.statsDoanhThuTXByMonth(diemDi, diemDen, fromDate, toDate);
    }

    @Override
    public List<Object[]> statsDoanhThuTXByYear(String diemDi, String diemDen, Date fromDate, Date toDate) {
        return this.statsRepository.statsDoanhThuTXByYear(diemDi, diemDen, fromDate, toDate);
    }
    
}
