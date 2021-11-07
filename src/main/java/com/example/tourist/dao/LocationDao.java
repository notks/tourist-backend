package com.example.tourist.dao;

import com.example.tourist.model.Location;

import java.util.List;
import java.util.Optional;

public interface LocationDao {

    int insertLocation(Location location);
    List<Location> getLocationByName(String name);
    Optional<Location> getLocationByImportance(String status);

}
