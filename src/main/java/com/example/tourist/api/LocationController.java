package com.example.tourist.api;

import com.example.tourist.model.Location;
import com.example.tourist.model.NewLocation;
import com.example.tourist.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@RequestMapping("locations")
@RestController
public class LocationController {
    private final LocationService locationService;
@Autowired
    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }
    @PostMapping
    public void addLocation(@RequestBody NewLocation location){
        System.out.println("0");

        locationService.addLocation(location);
    }
    @GetMapping
    public List<Location> getAll(){
    return locationService.getAllLocations();
    }
    @GetMapping(path="name/{name}")
    public List<Location> getLocationByName(@PathVariable("name") String name){
    System.out.println("0");
    return locationService.getByName(name);
}
   @GetMapping(path="importance/{status}")
   public List<Location> getByImportance(@PathVariable("status") String status){
      return locationService.getByImportance(status);
   }
   @GetMapping(path = "test")
    public String test (HttpServletRequest request){
    int userid=(Integer) request.getAttribute("id");
    return "Id is: "+ userid;
   }
   @GetMapping(path = "delete")
   int deleteLocationById(@RequestParam("id") int id){
    return locationService.deleteLocationById(id);
   }


}
