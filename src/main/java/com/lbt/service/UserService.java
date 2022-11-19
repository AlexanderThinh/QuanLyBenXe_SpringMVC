/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.lbt.service;

import com.lbt.pojos.User;
import java.util.List;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 *
 * @author DELL
 */
public interface UserService extends UserDetailsService {
    boolean addUser(User u);
    List<User> getUsers(String username);
    User getUserByID(int ID);
}
