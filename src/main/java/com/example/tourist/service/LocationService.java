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
    public LocationService(@Qualifier("postgres") LocationDao locationDao) {
        this.locationDao = locationDao;
    }
    public int addLocation(Location location){
        return locationDao.insertLocation(location);

    }
 public List<Location> getByName(String name){

    System.out.println("1");
    return locationDao.getLocationByName(name);
 }
 public Optional<Location> getByImportance(String status){
    return locationDao.getLocationByImportance(status);
 }
}
