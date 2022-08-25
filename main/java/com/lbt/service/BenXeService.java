/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.lbt.service;

import com.lbt.pojos.BenXe;
import java.util.List;

/**
 *
 * @author DELL
 */
public interface BenXeService {
    List<BenXe> getDSBenXe();
    BenXe getBenXeByID(int benXeID);
}
