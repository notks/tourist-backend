package com.example.tourist.dao;

import com.example.tourist.model.Location;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository("fakeDao")
public class LocationAccesService implements LocationDao{
    private static List<Location> DB=new ArrayList<>();
    @Override
    public int insertLocation(Location location){
        DB.add(location);
        return 1;
    }
    @Override
    public Optional<Location> getLocationByName(String name){
        return DB.stream().filter(location-> location.getName().equals(name)).findFirst();

    }

    @Override
    public Optional<Location> getLocationByImportance(String status) {
        return DB.stream().filter(location-> location.getIStatus().equals(status)).findFirst();
    }
}
