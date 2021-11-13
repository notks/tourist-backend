package com.example.tourist.service;

import com.example.tourist.dao.RatingDao;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class RatingService {
private final RatingDao ratingDao;

    public RatingService(@Qualifier("RatingRepository") RatingDao ratingDao) {
        this.ratingDao=ratingDao;
    }

    public boolean saveRating(int rating, int id){
        return ratingDao.saveRating(rating,id);
    }
    public double getAverageLocationRating(int id){
        return ratingDao.getAverageRating(id);
    }

}
