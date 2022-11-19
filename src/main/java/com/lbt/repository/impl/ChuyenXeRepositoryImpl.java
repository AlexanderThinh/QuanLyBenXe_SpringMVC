/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lbt.repository.impl;

import com.lbt.pojos.ChuyenXe;
import com.lbt.repository.ChuyenXeRepository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
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
public class ChuyenXeRepositoryImpl implements ChuyenXeRepository {
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    
    @Override
    public List<ChuyenXe> getDSChuyenXe(int nhaXeID, boolean giaoHang, String diemDi, String diemDen, Date ngayDi, int page) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<ChuyenXe> query = builder.createQuery(ChuyenXe.class);
        
        Root root = query.from(ChuyenXe.class);
        query = query.select(root);
        
        List<Predicate> predicates = new ArrayList<>();

        if(nhaXeID != 0) {
            Predicate p = builder.equal(root.get("nhaXeId"), nhaXeID);
            predicates.add(p);
        }
        
        if(giaoHang == true) {
            Predicate p = builder.equal(root.get("nhaXeId").get("giaoHang"), giaoHang);
            predicates.add(p);
        }
        
        if(diemDi != null && !diemDi.isEmpty()) {
            Predicate p = builder.like(root.get("tuyenXeId").get("diemDi").as(String.class), 
                        String.format("%%%s%%", diemDi.trim()));
            predicates.add(p);
        }
        
        if(diemDen != null && !diemDen.isEmpty()) {
            Predicate p = builder.like(root.get("tuyenXeId").get("diemDen").as(String.class), 
                        String.format("%%%s%%", diemDen.trim()));
            predicates.add(p);
        }
        if(ngayDi != null) {
            predicates.add(builder.equal(root.get("ngayDi"), ngayDi));
        }

        query.where(predicates.toArray(new Predicate[] {}));
        predicates.toArray();
        
        
        Query q = session.createQuery(query);
        
        return q.getResultList();
    }

    @Override
    public boolean addChuyenXe(ChuyenXe cx) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(cx);
            
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        
        return false;
    }

    @Override
    public ChuyenXe getChuyenXeByID(int ID) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        ChuyenXe cx = session.get(ChuyenXe.class, ID);
        
        return cx;
    }
    
}
