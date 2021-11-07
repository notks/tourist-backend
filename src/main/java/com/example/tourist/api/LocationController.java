package com.example.tourist.api;

import com.example.tourist.model.Location;
import com.example.tourist.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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
    @GetMapping(path="name/{name}")
    public List<Location> getLocationByName(@PathVariable("name") String name){
    System.out.println("0");
    return locationService.getByName(name);
}
   @GetMapping(path="importance/{status}")
   public Location getByImportance(@PathVariable("status") String status){
      return locationService.getByImportance(status).orElse(null);
   }
   @GetMapping(path = "test")
    public String test (HttpServletRequest request){
    int userid=(Integer) request.getAttribute("id");
    return "Id is: "+ userid;
   }

}
