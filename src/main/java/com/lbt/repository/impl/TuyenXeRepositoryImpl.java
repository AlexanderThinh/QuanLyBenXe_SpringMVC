/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lbt.repository.impl;

import com.lbt.pojos.ChuyenXe;
import com.lbt.pojos.DonDatVe;
import com.lbt.pojos.TuyenXe;
import com.lbt.repository.TuyenXeRepository;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
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
public class TuyenXeRepositoryImpl implements TuyenXeRepository{
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<TuyenXe> getAllTuyenXe() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<TuyenXe> query = builder.createQuery(TuyenXe.class);
        
        Root root = query.from(TuyenXe.class);
        query = query.select(root);
        
        Query q = session.createQuery(query);
        
        return q.getResultList();
    }

    @Override
    public List<Object []> getTopTuyenXe(int topNumber) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Object []> query = builder.createQuery(Object [].class);
        
        Root rootTX = query.from(TuyenXe.class);
        Root rootCX = query.from(ChuyenXe.class);
        Root rootDDV = query.from(DonDatVe.class);
        
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(builder.equal(rootTX.get("id"), rootCX.get("tuyenXeId")));
        predicates.add(builder.equal(rootCX.get("id"), rootDDV.get("chuyenXeId")));
        
        query.multiselect(rootTX.get("id"), rootTX.get("diemDi"), rootTX.get("diemDen"),
                rootTX.get("quangDuong"), rootTX.get("timeDiChuyen"), rootCX.get("gia"), 
                rootTX.get("image"), builder.count(rootDDV.get("id")));
        
        query.where(predicates.toArray(new Predicate[] {}));
        query.groupBy(rootTX.get("id"));
        
        Query q = session.createQuery(query);
        q.setMaxResults(topNumber);
        
        return q.getResultList();
    }

    @Override
    public TuyenXe getTuyeXeByID(int tuyenXeID) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        TuyenXe tx = session.get(TuyenXe.class, tuyenXeID);
        
        return tx;
    }

    @Override
    public boolean addTuyenXe(TuyenXe tx) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(tx);
            
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        
        return false;
    }
    
}
