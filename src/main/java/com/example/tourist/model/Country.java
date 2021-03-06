package com.example.tourist.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Country {
   private String name;
   private int id;

    public Country(@JsonProperty("name") String name,int id) {
        this.name = name;
        this.id=id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
