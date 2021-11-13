package com.example.tourist.api;

import com.example.tourist.model.Location;
import com.example.tourist.model.NewLocation;
import com.example.tourist.service.LocationService;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("locations")

public class LocationController {

    private final LocationService locationService;

    @Autowired
    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }


    @PostMapping("/protected")
    public ResponseEntity<?> addLocation(@RequestBody NewLocation location) {

if(locationService.addLocation(location))return new ResponseEntity<>(null, HttpStatus.CREATED);else return new ResponseEntity<>(null, HttpStatus.CONFLICT);

    }

    @GetMapping("/protected")
    public List<Location> getLocations() {
        return locationService.getAllLocations();
    }

    @GetMapping
    public List<Location> getActiveAll() {
        return locationService.getAllActiveLocations();
    }

    @GetMapping(path = "name/{name}")
    public List<Location> getLocationByName(@PathVariable("name") String name) {

        return locationService.getByName(name);
    }

    @GetMapping(path = "importance/{status}")
    public List<Location> getByImportance(@PathVariable("status") String status) {
        return locationService.getByImportance(status);
    }

    @DeleteMapping("protected")
    int deleteLocationById(@RequestParam("id") int id) {
        return locationService.deleteLocationById(id);
    }

    @PutMapping(path = "protected/status")
    int deactivateActivate(@RequestParam("action") String action, @RequestParam("id") int id) {
        if (action.equals("activate")) {
            return locationService.activate(id);
        } else if (action.equals("deactivate")) {
            return locationService.deactivate(id);
        }
        return 1;

    }


}
