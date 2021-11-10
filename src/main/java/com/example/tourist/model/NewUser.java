package com.example.tourist.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NewUser {
    private String email;
    private String password;

    public NewUser(@JsonProperty("email") String email, @JsonProperty("password") String password) {
        this.email = email;
        this.password = password;
    }



    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }


    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
