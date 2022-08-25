/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lbt.controllers;

import com.lbt.pojos.TuyenXe;
import com.lbt.repository.UserRepository;
import com.lbt.service.ChuyenXeService;
import com.lbt.service.NhaXeService;
import com.lbt.service.RatingService;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author DELL
 */
@Controller
@ControllerAdvice
@Transactional
public class HomeController {
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    
    @Autowired
    private NhaXeService nhaXeService;
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private RatingService ratingService;
    
        
    @ModelAttribute
    public void commonAttr(Model model, HttpSession session) {
        model.addAttribute("listNhaXe", this.nhaXeService.getAllNhaXe(1));
        model.addAttribute("currentUser", session.getAttribute("currentUser"));
    }
    
    @RequestMapping("/")
    public String index(Model model) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("from BenXe");
        
        TuyenXe tx2 = session.get(TuyenXe.class, 2);
        
        model.addAttribute("listBenXe", q.getResultList());   
        model.addAttribute("tx2", tx2); 
        model.addAttribute("testString", "AlexanderThinh");
        model.addAttribute("user2", this.userRepository.getUserByID(2));
        
        model.addAttribute("rating", this.ratingService.getRatingByUserAndNhaXe(2, 3).get(0));
        
        return "index";
    }
}
