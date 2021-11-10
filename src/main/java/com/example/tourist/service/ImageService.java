package com.example.tourist.service;

import com.example.tourist.dao.ImageDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class ImageService {
private final ImageDao imageDao;
@Autowired
    public ImageService(@Qualifier("Picture") ImageDao imageDao) {
        this.imageDao = imageDao;
    }


    public String savePicture(MultipartFile file,int id){
return imageDao.upload(file,id);
    }
    public List<String> getAllLocationImages(int id){
    return imageDao.getPictureByLocationId(id);
    }
}
