/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lbt.repository.impl;

import com.lbt.pojos.DonDatVe;
import com.lbt.repository.BookingRepository;
import org.hibernate.HibernateException;
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
public class BookingRepositoryImpl implements BookingRepository { 
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public DonDatVe booking(DonDatVe ddv) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        
        try {
            session.save(ddv);
            
            return ddv;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
}
