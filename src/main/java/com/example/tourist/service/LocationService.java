package com.example.tourist.service;

import com.example.tourist.dao.LocationDao;
import com.example.tourist.model.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<Location> getAllLocations(){
        return locationDao.getAllLocations();
    }

}
