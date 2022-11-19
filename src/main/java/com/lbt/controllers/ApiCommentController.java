/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lbt.controllers;

import com.lbt.pojos.Comment;
import com.lbt.pojos.User;
import com.lbt.repository.UserRepository;
import com.lbt.service.CommentService;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author DELL
 */
@RestController
@RequestMapping("/api")
public class ApiCommentController {
    @Autowired
    private CommentService commentService;
    
    @PostMapping(path="/add-comment/{nhaXeID}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Comment> addComment(@RequestBody Map<String, String> params,
            HttpSession session, @PathVariable(value = "nhaXeID") int nhaXeID) {
        User currentUser = (User) session.getAttribute("currentUser");
        
        if (currentUser != null) {
            try {
                String noiDung = params.get("noiDung");

                Comment c = this.commentService.addComment(noiDung, nhaXeID, currentUser);

                return new ResponseEntity<>(c, HttpStatus.CREATED);
            } catch(Exception ex) {
                ex.printStackTrace();
            }
        } 
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
