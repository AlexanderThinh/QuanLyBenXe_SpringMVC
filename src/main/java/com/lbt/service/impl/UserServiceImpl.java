/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lbt.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.lbt.pojos.User;
import com.lbt.repository.UserRepository;
import com.lbt.service.UserService;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author DELL
 */
@Service("userDetailsService")
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    
    @Autowired
    private Cloudinary cloudinary;

    @Override
    public boolean addUser(User u) {
        try {
//        1. Truoc khi luu doi tuong user -> lay mk -> bam mk
            String password = u.getPassword();
            u.setPassword(this.passwordEncoder.encode(password));
            u.setUserRole(User.USER);
            u.setActive(Boolean.TRUE);
        
//        2. Luu duong dan anh sau khi upload len cloudinary            
            Map response = this.cloudinary.uploader().upload(u.getFile().getBytes(),
                    ObjectUtils.asMap("resource_type", "auto"));
//            Lay duong dan anh tren cloudinary sau khi upload thanh cong
            String img =  (String) response.get("secure_url"); 
            u.setAvatar(img);
            
            return this.userRepository.addUser(u);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        return false;
    }

    @Override
    public List<User> getUsers(String username) {
        return this.userRepository.getUsers(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<User> users = this.getUsers(username);
        
        if(users.isEmpty()) {
            throw new UsernameNotFoundException("User does not exist");
        }
        
//        Lay ra doi tuong user theo username (username truyen vao luc dang nhap)
        User u = users.get(0);
        
        Set<GrantedAuthority> auth = new HashSet<>();
        auth.add(new SimpleGrantedAuthority(u.getUserRole()));
        
        return new org.springframework.security.core.userdetails
                .User(u.getUsername(), u.getPassword(), auth);
    }

    @Override
    public User getUserByID(int ID) {
        return this.userRepository.getUserByID(ID);
    }
}
