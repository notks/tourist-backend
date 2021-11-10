package com.example.tourist.api;

import com.example.tourist.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("picture")
public class ImageController {
    private final ImageService imageService;
@Autowired
    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @PostMapping
    @CrossOrigin(origins = "http://127.0.0.1:8080/picture")

    public String saveImage( @RequestParam("file") MultipartFile file,@RequestParam("locationId") int id){
        System.out.println("1");
        System.out.println(file.getOriginalFilename());
        return imageService.savePicture(file,id);
    }
    @GetMapping()
    public List<String> getImages(int id){
    return imageService.getAllLocationImages(id);
    }
}
