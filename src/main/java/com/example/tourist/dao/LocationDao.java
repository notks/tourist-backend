package com.example.tourist.dao;

import com.example.tourist.model.Location;
import com.example.tourist.model.NewLocation;

import java.util.List;
import java.util.Optional;

public interface LocationDao {

    int insertLocation(NewLocation location);
    List<Location> getLocationByName(String name);
    List<Location> getLocationByImportance(String status);
    List<Location> getAllActiveLocations();
    List<Location> getAllLocations();

    boolean removeLocation(int id);
    boolean activate(int id);
    boolean deactivate(int id);

}
