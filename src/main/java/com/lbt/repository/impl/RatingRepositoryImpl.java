/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lbt.repository.impl;

import com.lbt.pojos.Rating;
import com.lbt.repository.RatingRepository;
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
public class RatingRepositoryImpl implements RatingRepository {
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<Rating> getRatingByUserAndNhaXe(int userID, int nhaXeID) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Rating> query = builder.createQuery(Rating.class);
        
        Root root = query.from(Rating.class);
        query = query.select(root);
        
        List<Predicate> predicates = new ArrayList<>();
        
        if (userID != 0) {
            Predicate p = builder.equal(root.get("userId"), userID);
            predicates.add(p);
        }
        
        if (nhaXeID != 0) {
            Predicate p = builder.equal(root.get("nhaXeId"), nhaXeID);
            predicates.add(p);
        }
        query.where(predicates.toArray(new Predicate[] {}));
        predicates.toArray();
        
        Query q = session.createQuery(query);
        
        return q.getResultList();
    }

    @Override
    public boolean ratingNhaXe(Rating r) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        
        try {
            session.saveOrUpdate(r);
            
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
