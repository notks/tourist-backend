package com.example.tourist.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class City {
    private String name;
    private int country_id;
    private int id;

    public City(@JsonProperty("name") String name,@JsonProperty("country_id") int country_id,int id) {
        this.name = name;
        this.country_id = country_id;
        this.id=id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCountry_id() {
        return country_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountry_id(int country_id) {
        this.country_id = country_id;
    }
}
