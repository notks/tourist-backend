package com.example.tourist.service;

import com.example.tourist.dao.LocationDao;
import com.example.tourist.model.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationService {
    private final LocationDao locationDao;
@Autowired
    public LocationService(@Qualifier("fakeDao") LocationDao locationDao) {
        this.locationDao = locationDao;
    }
    public int addLocation(Location location){
        return locationDao.insertLocation(location);

    }
 public Optional<Location> getByName(String name){
    return locationDao.getLocationByName(name);
 }
 public Optional<Location> getByImportance(String status){
    return locationDao.getLocationByImportance(status);
 }
}
