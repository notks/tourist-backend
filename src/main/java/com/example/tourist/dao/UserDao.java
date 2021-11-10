package com.example.tourist.dao;

import com.example.tourist.Exeptions.EtAuthException;
import com.example.tourist.model.NewUser;
import com.example.tourist.model.User;

import java.util.Optional;

public interface UserDao {
    String validateUser(String email, String password) throws EtAuthException;
    NewUser registerUser(NewUser user) throws EtAuthException;
    int updatePassword(User user,String newPwd)throws EtAuthException;
    int updateEmail(User user,String newEmail)throws EtAuthException;
    String generateJWT(User user) throws EtAuthException;
    public User findUser(String email, String password) throws EtAuthException;
}
