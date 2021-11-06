package com.example.tourist.model;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Location {
    private String Name;
    private String Description;
    private double Longitude;
    private double Latitude;
    private String Status;
    private double Timestamp;
    private String IStatus;
    private String City;
    private double id;

    public Location(@JsonProperty("name") String name,@JsonProperty("description") String description, @JsonProperty("long")double longitude,@JsonProperty("lat") double latitude, @JsonProperty("status") String status,@JsonProperty("istat") String IStatus,@JsonProperty("city") String city) {
        Name = name;
        Description = description;
        Longitude = longitude;
        Latitude = latitude;
        Status = status;
        Timestamp = Math.random();
        this.IStatus = IStatus;
        City = city;
        this.id =  Math.random();
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

    public Double getTimestamp() {
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

    public void setTimestamp(double timestamp) {
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
