package com.example.tourist.api;

import com.example.tourist.model.Location;
import com.example.tourist.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



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
    @GetMapping(path="name/{name}")
    public Location getAllLocations(@PathVariable("name") String name){
    return locationService.getByName(name).orElse(null);
}
   @GetMapping(path="importance/{status}")
   public Location getByImportance(@PathVariable("status") String status){
      return locationService.getByImportance(status).orElse(null);
   }

}
