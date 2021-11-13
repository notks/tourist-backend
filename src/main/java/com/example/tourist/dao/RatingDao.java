package com.example.tourist.dao;

import jdk.dynalink.linker.LinkerServices;

import java.util.List;

public interface RatingDao {
    boolean saveRating(int rating,int id);
    double getAverageRating(int id);
}
