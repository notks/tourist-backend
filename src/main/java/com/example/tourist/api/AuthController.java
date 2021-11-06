package com.example.tourist.api;

import com.example.tourist.model.User;
import com.example.tourist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

@RequestMapping("login")
@RestController
public class AuthController {


    private final UserService userService;
@Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping()
    public User validateUser(@RequestParam("email") String email, @RequestParam("pwd") String password){

    return userService.getUser(email,password);
    }
@PostMapping(path = "register")
    public String registerUser(@RequestBody User user){
try{
    userService.registerUser(user);
    return "User created";
}catch (Exception e){
    System.out.println(e);
    return "User not created";
}


    }
}
