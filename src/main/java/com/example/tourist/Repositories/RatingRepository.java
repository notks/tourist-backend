package com.example.tourist.Repositories;

import com.example.tourist.dao.RatingDao;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository("RatingRepository")

public class RatingRepository implements RatingDao {



    @Autowired
JdbcTemplate jdbcTemplate;



    @Override
    public boolean saveRating(int rating, int id) {

String sql="insert into Ratings (grade,location_id) values(?,?)";

       try {
           jdbcTemplate.update(
                   sql,rating,id);
return true;
       }catch (Exception e){

           return false;
       }
    }

    @Override
    public double getAverageRating(int id) {

        String sql="Select avg(grade) from Ratings where location_id=?";
        String sql2="select count(*) from Ratings where location_id=?;";
        int count=jdbcTemplate.queryForObject(
                sql2, new Object[] { id},Integer.class);
        if(count!=0){

           return jdbcTemplate.queryForObject(sql,new Object[]{id},Double.class);
        }




        return 0;
    }
}
