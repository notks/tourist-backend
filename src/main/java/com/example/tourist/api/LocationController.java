package com.example.tourist.api;

import com.example.tourist.model.Location;
import com.example.tourist.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("location")
@RestController
public class LocationController {
    private final LocationService locationService;
@Autowired
    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }
    @PostMapping
    public void addLocation(@RequestBody Location location){
        locationService.addLocation(location);
    }
    @GetMapping
    public List<Location> getAllLocations(){
        return locationService.getAllLocations();
    }

}
