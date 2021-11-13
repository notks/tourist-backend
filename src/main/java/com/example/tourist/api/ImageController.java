package com.example.tourist.api;

import com.example.tourist.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("image")
public class ImageController {
    private final ImageService imageService;

    @Autowired
    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @PostMapping

    public ResponseEntity<?> saveImage(@RequestParam("file") MultipartFile file, @RequestParam("locationId") int id) {
        imageService.savePicture(file, id);
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }

    @GetMapping()
    public Map<String, List<String>> getImages(int id) {
        HashMap<String, List<String>> response = new HashMap<>();
        response.put("url", imageService.getAllLocationImages(id));
        return response;
    }

}
