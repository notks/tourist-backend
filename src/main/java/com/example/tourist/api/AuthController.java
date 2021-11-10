package com.example.tourist.api;

import com.example.tourist.model.NewUser;
import com.example.tourist.model.User;
import com.example.tourist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
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

@PostMapping(path = "register")
    public ResponseEntity<?> registerUser(@RequestBody NewUser user){

    NewUser test=userService.registerUser(user);
    if(test!=null){
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
    return new ResponseEntity<>(null, HttpStatus.CONFLICT);


    }
}
