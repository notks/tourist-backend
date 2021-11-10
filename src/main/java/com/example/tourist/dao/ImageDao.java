package com.example.tourist.dao;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ImageDao {
    public List<String> getPictureByLocationId(int id);
public String upload(MultipartFile file,int id);
    public int save(String path,int LocationId);
}
