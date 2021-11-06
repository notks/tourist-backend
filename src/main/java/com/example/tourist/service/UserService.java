package com.example.tourist.service;

import com.example.tourist.dao.UserDao;
import com.example.tourist.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserDao userDao;
@Autowired
    public UserService(@Qualifier("userpsql") UserDao userDao) {
        this.userDao = userDao;
    }
    public User getUser(String email, String password){
    return userDao.validateUser(email,password);
    }
    public User registerUser(User user){
    return userDao.registerUser(user);
    }
}
