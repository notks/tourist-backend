package com.example.tourist.dao;

import com.example.tourist.model.Location;

import java.util.List;

public interface LocationDao {

    int insertLocation(Location location);
    List<Location> getAllLocations();
}
