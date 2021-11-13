package com.example.tourist.service;

import com.example.tourist.dao.LocationDao;
import com.example.tourist.model.Location;
import com.example.tourist.model.NewLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LocationService {
    private final LocationDao locationDao;
@Autowired
    public LocationService(@Qualifier("postgres") LocationDao locationDao) {
        this.locationDao = locationDao;
    }
    public boolean addLocation(NewLocation location){

        return locationDao.insertLocation(location);

    }
 public List<Location> getByName(String name){

    return locationDao.getLocationByName(name);
 }
 public List<Location> getByImportance(String status){
    return locationDao.getLocationByImportance(status);
 }
 public List<Location> getAllActiveLocations(){return locationDao.getAllActiveLocations();}
    public List<Location> getAllLocations(){return locationDao.getAllLocations();}
public int activate(int id) {
    if(locationDao.activate(id))return 0;else return 1;}
    public int deactivate(int id) {if(locationDao.deactivate(id))return 0;else return 1;}

    public int deleteLocationById(int id) {
       if(locationDao.removeLocation(id))return 0;else return 1;

    }

}
