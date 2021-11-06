package com.example.tourist.api;

import com.example.tourist.model.User;
import com.example.tourist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RequestMapping("login")
@RestController
public class AuthController {


    private final UserService userService;
@Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping()
    public User getUser(@RequestParam("email") String email, @RequestParam("pwd") String password){

    return userService.getUser(email,password);
    }
}
