package com.example.tourist.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Timestamp;

public class NewLocation {




        private String Name;
        private String Description;
        private double Longitude;
        private double Latitude;
        private String Status;
        private java.sql.Timestamp Timestamp;
        private String IStatus;

        private int city_id;
        private int country_id;
        private double id;

        public NewLocation(
                @JsonProperty("name") String name,
                @JsonProperty("description") String description,
                @JsonProperty("long")double longitude,
                @JsonProperty("lat") double latitude,
                @JsonProperty("status") String status,
                @JsonProperty("istat") String IStatus,
                @JsonProperty("city_id") int city_id,
                @JsonProperty("country_id") int country_id
                ) {
            Name = name;
            Description = description;
            Longitude = longitude;
            Latitude = latitude;
            Status = status;

            this.IStatus = IStatus;
            this.city_id = city_id;
            this.country_id=country_id;
        }



        public void setCity_id(int city_id) {
            this.city_id = city_id;
        }

        public void setCountry_id(int country_id) {
            this.country_id = country_id;
        }

        public void setId(double id) {
            this.id = id;
        }



        public int getCity_id() {
            return city_id;
        }

        public int getCountry_id() {
            return country_id;
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


    }


