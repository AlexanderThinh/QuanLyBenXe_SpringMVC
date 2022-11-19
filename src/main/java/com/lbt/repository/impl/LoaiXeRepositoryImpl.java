/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lbt.repository.impl;

import com.lbt.pojos.LoaiXe;
import com.lbt.repository.LoaiXeRepository;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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
public class LoaiXeRepositoryImpl implements LoaiXeRepository {
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public LoaiXe getLoaiXeByID(int loaiXeID) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        LoaiXe lx = session.get(LoaiXe.class, loaiXeID);
        
        return lx;
    }

    @Override
    public List<LoaiXe> getAllLoaiXe() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<LoaiXe> query = builder.createQuery(LoaiXe.class);
        
        Root root = query.from(LoaiXe.class);
        query = query.select(root);
        
        Query q = session.createQuery(query);
        
        return q.getResultList();
    }
    
}
