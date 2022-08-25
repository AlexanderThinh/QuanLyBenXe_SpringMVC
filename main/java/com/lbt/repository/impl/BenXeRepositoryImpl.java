/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lbt.repository.impl;

import com.lbt.pojos.BenXe;
import com.lbt.repository.BenXeRepository;
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
public class BenXeRepositoryImpl implements BenXeRepository {
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<BenXe> getDSBenXe() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<BenXe> query = builder.createQuery(BenXe.class);
        
        Root root = query.from(BenXe.class);
        query = query.select(root);
        
        Query q = session.createQuery(query);
        
        return q.getResultList();
    }

    @Override
    public BenXe getBenXeByID(int benXeID) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        
        BenXe bx = session.get(BenXe.class, benXeID);
        
        return bx;
    }
    
}
