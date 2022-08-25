/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.lbt.repository;

import com.lbt.pojos.User;
import java.util.List;

/**
 *
 * @author DELL
 */
public interface UserRepository {
    boolean addUser(User u);
    List<User> getUsers(String username);
    User getUserByID(int ID);
}
