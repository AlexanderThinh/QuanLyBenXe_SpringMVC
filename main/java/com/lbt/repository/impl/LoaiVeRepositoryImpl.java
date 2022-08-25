/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lbt.repository.impl;

import com.lbt.pojos.LoaiVe;
import com.lbt.repository.LoaiVeRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author DELL
 */
@Repository
@Transactional
public class LoaiVeRepositoryImpl implements LoaiVeRepository {
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public LoaiVe getLoaiVeByID(int ID) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        LoaiVe lv = session.get(LoaiVe.class, ID);
        
        return lv;
    }
    
}
