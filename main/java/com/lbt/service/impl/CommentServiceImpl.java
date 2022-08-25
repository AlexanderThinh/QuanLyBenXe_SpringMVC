/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lbt.service.impl;

import com.lbt.pojos.Comment;
import com.lbt.pojos.NhaXe;
import com.lbt.pojos.User;
import com.lbt.repository.CommentRepository;
import com.lbt.repository.NhaXeRepository;
import com.lbt.service.CommentService;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DELL
 */
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepository commentRepository;
    
    @Autowired
    private NhaXeRepository nhaXeRepository;

    @Override
    public Comment addComment(String noiDung, int nhaXeID, User creator) {
        NhaXe nx = this.nhaXeRepository.getNhaXeByID(nhaXeID);
        
        Comment c = new Comment();
        
        c.setNoiDung(noiDung);
        c.setNhaXeId(nx);
        c.setUser(creator);
        c.setCreatedDate(new Date());
        c.setUpdatedDate(new Date());
        
        return this.commentRepository.addComment(c);
        
    }
    
}
