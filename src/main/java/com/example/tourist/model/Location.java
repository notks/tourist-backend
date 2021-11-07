package com.example.tourist.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Timestamp;


public class Location {
    private String Name;
    private String Description;
    private double Longitude;
    private double Latitude;
    private String Status;
    private Timestamp Timestamp;
    private String IStatus;
    private String City;
    private String Country;
    private double id;

    public Location(@JsonProperty("name") String name, @JsonProperty("description") String description, @JsonProperty("long")double longitude, @JsonProperty("lat") double latitude, @JsonProperty("status") String status, @JsonProperty("istat") String IStatus, @JsonProperty("city") String city,String country, java.sql.Timestamp timestamp, int id) {
        Name = name;
        Description = description;
        Longitude = longitude;
        Latitude = latitude;
        Status = status;
        Timestamp =timestamp ;
        this.IStatus = IStatus;
        City = city;
        this.Country=country;
        this.id =  id;
    }

    public String getName() {
        return Name;
    }

    public String getDescription() {
        return Description;
    }

    public double getLongitude() {
        return Longitude;
    }

    public double getLatitude() {
        return Latitude;
    }

    public String getStatus() {
        return Status;
    }

    public Timestamp getTimestamp() {
        return Timestamp;
    }

    public String getIStatus() {
        return IStatus;
    }

    public String getCity() {
        return City;
    }

    public double getId() {
        return id;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setLongitude(double longitude) {
        Longitude = longitude;
    }

    public void setLatitude(double latitude) {
        Latitude = latitude;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public void setTimestamp(Timestamp timestamp) {
        Timestamp = timestamp;
    }

    public void setIStatus(String IStatus) {
        this.IStatus = IStatus;
    }

    public void setCity(String city) {
        City = city;
    }

    public void setId(long id) {
        this.id = id;
    }
}
