package com.example.tourist.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
    private int id;
    private String email;
    private String password;

    public User(@JsonProperty("email") String email, @JsonProperty("password") String password,int id) {
        this.id=id;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
