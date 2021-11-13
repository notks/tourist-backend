package com.example.tourist.api;


import com.example.tourist.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("rating")
@CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET, RequestMethod.POST})

public class RatingController {
    private final RatingService ratingService;

    @Autowired
    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }


    @PostMapping(path = "/update")
    public boolean saveRating(@RequestParam("rating") int rating, @RequestParam("id") int id) {
        return ratingService.saveRating(rating, id);
    }

    @GetMapping
    public double getAverageRating(@RequestParam("id") int id) {
        return ratingService.getAverageLocationRating(id);
    }

}
