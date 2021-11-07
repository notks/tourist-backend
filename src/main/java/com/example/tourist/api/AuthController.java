package com.example.tourist.api;

import com.example.tourist.model.User;
import com.example.tourist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("login")
@RestController
public class AuthController {


    private final UserService userService;
@Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping()
    public Map<String,String> getUserToken (@RequestParam("email") String email, @RequestParam("pwd") String password){
        Map<String,String> response=new HashMap<>();
        response.put("token",userService.getToken(email,password));
     return response;

    }
    @GetMapping(path = "test")
    public String test(@RequestParam("email") String email, @RequestParam("pwd") String password){

        return userService.test(email,password);
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
