package com.example.tourist.api;

import com.example.tourist.model.City;
import com.example.tourist.service.CityService;
import com.example.tourist.service.CountryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/protected/city")
public class CityController {
    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @PostMapping
    ResponseEntity<?> saveCity(@RequestBody City city) {


        if (cityService.save(city.getName(),city.getCountry_id())) {

            return new ResponseEntity<>(null, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(null, HttpStatus.CONFLICT);
        }
    }

    @GetMapping
    ResponseEntity<?> getCitiesByCountry(@RequestParam("country_id") int id) {
        List<City> list = cityService.getCities(id);
        if (list.isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
    }

}
