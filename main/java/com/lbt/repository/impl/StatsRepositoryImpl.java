/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lbt.repository.impl;

import com.lbt.pojos.ChuyenXe;
import com.lbt.pojos.DonDatVe;
import com.lbt.pojos.TuyenXe;
import com.lbt.repository.StatsRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
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
public class StatsRepositoryImpl implements StatsRepository {
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

//    Thong ke doanh thu tuyen xe theo thang     
    @Override
    public List<Object[]> statsDoanhThuTXByMonth(String diemDi, String diemDen, Date fromDate, Date toDate) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Object []> query = builder.createQuery(Object[].class);
        
        Root rootTuyenXe = query.from(TuyenXe.class);
        Root rootChuyenXe = query.from(ChuyenXe.class);
        Root rootDonDatVe = query.from(DonDatVe.class);
        
//        Join 3 bang su dung Predicate de ket hop nhieu dien kien join
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(builder.equal(rootTuyenXe.get("id"), rootChuyenXe.get("tuyenXeId")));
        predicates.add(builder.equal(rootChuyenXe.get("id"), rootDonDatVe.get("chuyenXeId")));
        
        query.multiselect(builder.function("MONTH", Integer.class, rootDonDatVe.get("createdDate")),
                builder.function("YEAR", Integer.class, rootDonDatVe.get("createdDate")),
                builder.sum(rootDonDatVe.get("gia")));
        
        if (diemDi != null && !diemDi.isEmpty()) {
            predicates.add(builder.like(rootTuyenXe.get("diemDi").as(String.class), String.format("%%%s%%", diemDi.trim())));
        }
        
        if (diemDen != null && !diemDen.isEmpty()) {
            predicates.add(builder.like(rootTuyenXe.get("diemDen").as(String.class), String.format("%%%s%%", diemDen.trim())));
        }
        
        if(fromDate != null) {
            predicates.add(builder.greaterThanOrEqualTo(rootDonDatVe.get("createdDate"), fromDate));
        }
        
        if(toDate != null) {
            predicates.add(builder.lessThanOrEqualTo(rootDonDatVe.get("createdDate"), toDate));
        }
        
        query.where(predicates.toArray(new Predicate[] {}));
        query = query.groupBy(builder.function("MONTH", Integer.class, rootDonDatVe.get("createdDate")),
                builder.function("YEAR", Integer.class, rootDonDatVe.get("createdDate")));
        
        Query q = session.createQuery(query);
        
        return q.getResultList();
    }

    @Override
    public List<Object[]> statsDoanhThuTXByYear(String diemDi, String diemDen, Date fromDate, Date toDate) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Object []> query = builder.createQuery(Object[].class);
        
        Root rootTuyenXe = query.from(TuyenXe.class);
        Root rootChuyenXe = query.from(ChuyenXe.class);
        Root rootDonDatVe = query.from(DonDatVe.class);
        
//        Join 3 bang su dung Predicate de ket hop nhieu dien kien join
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(builder.equal(rootTuyenXe.get("id"), rootChuyenXe.get("tuyenXeId")));
        predicates.add(builder.equal(rootChuyenXe.get("id"), rootDonDatVe.get("chuyenXeId")));
        
        query.multiselect(builder.function("YEAR", Integer.class, rootDonDatVe.get("createdDate")),
                builder.sum(rootDonDatVe.get("gia")));
        
        if (diemDi != null && !diemDi.isEmpty()) {
            predicates.add(builder.like(rootTuyenXe.get("diemDi").as(String.class), String.format("%%%s%%", diemDi.trim())));
        }
        
        if (diemDen != null && !diemDen.isEmpty()) {
            predicates.add(builder.like(rootTuyenXe.get("diemDen").as(String.class), String.format("%%%s%%", diemDen.trim())));
        }
        
        if(fromDate != null) {
            predicates.add(builder.greaterThanOrEqualTo(rootDonDatVe.get("createdDate"), fromDate));
        }
        
        if(toDate != null) {
            predicates.add(builder.lessThanOrEqualTo(rootDonDatVe.get("createdDate"), toDate));
        }
        
        query.where(predicates.toArray(new Predicate[] {}));
        query = query.groupBy(builder.function("YEAR", Integer.class, rootDonDatVe.get("createdDate")));
        
        Query q = session.createQuery(query);
        
        return q.getResultList();
    }
    
}
