/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.lbt.service;

import com.lbt.pojos.Comment;
import com.lbt.pojos.User;

/**
 *
 * @author DELL
 */
public interface CommentService {
    Comment addComment(String noiDung, int nhaXeID, User creator);
}
