package com.example.tourist.dao;

import com.example.tourist.model.Location;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository("fakeDao")
public class LocationAccesService implements LocationDao{
    private static List<Location> DB=new ArrayList<>();
    @Override
    public int insertLocation(Location location){
        DB.add(location);
        return 1;
    }
    @Override
    public List<Location> getAllLocations(){
        return DB;
    }
}
