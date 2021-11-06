package com.example.tourist.dao;

import com.example.tourist.Exeptions.EtAuthException;
import com.example.tourist.model.User;

import java.util.Optional;

public interface UserDao {
    User validateUser(String email, String password) throws EtAuthException;
    int registerUser(String email,String pwd) throws EtAuthException;
    int updatePassword(User user,String newPwd)throws EtAuthException;
    int updateEmail(User user,String newEmail)throws EtAuthException;


}
