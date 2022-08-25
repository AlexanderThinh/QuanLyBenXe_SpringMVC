/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lbt.repository.impl;

import com.lbt.pojos.NhaXe;
import com.lbt.pojos.Rating;
import com.lbt.repository.NhaXeRepository;
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
public class NhaXeRepositoryImpl implements NhaXeRepository{
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<NhaXe> getAllNhaXe(int isActive) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<NhaXe> query = builder.createQuery(NhaXe.class);
        
        Root root = query.from(NhaXe.class);
        query = query.select(root);
        
        List<Predicate> predicates = new ArrayList<>();
        if (isActive == 1) {
            Predicate p = builder.equal(root.get("active"), 1);
            predicates.add(p);
        }
        
        query.where(predicates.toArray(new Predicate[] {}));
        query = query.orderBy(builder.desc(root.get("id")));
        predicates.toArray();
        
        Query q = session.createQuery(query);

        return q.getResultList();
    }

    @Override
    public NhaXe getNhaXeByID(int nhaXeID) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        NhaXe nx = session.get(NhaXe.class, nhaXeID);
        
        return nx;
    }

    @Override
    public NhaXe addNhaXe(NhaXe nx) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(nx);
            
            return nx;
        } catch(HibernateException ex) {
            ex.printStackTrace();
        }
        
        return null;
    }

    @Override
    public boolean updateActiveNhaXe(NhaXe nx) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        
        try {
            if (nx.getActive() == true) {
                nx.setActive(Boolean.FALSE);
            } else {
                nx.setActive(Boolean.TRUE);
            }
            session.update(nx);
            
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        
        return false;
    }
    
}
