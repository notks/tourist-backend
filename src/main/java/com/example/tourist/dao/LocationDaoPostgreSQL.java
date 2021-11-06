package com.example.tourist.dao;

import com.example.tourist.model.Location;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
@Repository("postgres")

public class LocationDaoPostgreSQL implements LocationDao {

NamedParameterJdbcTemplate template;

    public LocationDaoPostgreSQL(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    @Override
    public int insertLocation(Location location){
        final String sql = "insert into Locations(name, country_id , description,longitude,latitude,createdat,status,importance_status,city_id) values(:name, :country_id , :description,:longitude,:latitude,:createdat,:status,:importance_status,:city_id)";

        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("name", location.getName())
                .addValue("country_id", 5)
                .addValue("city_id", 3)
                .addValue("description", location.getDescription())
                .addValue("longitude",location.getLongitude())
                .addValue("createdat",new Timestamp(new Date().getTime()))
                .addValue("latitude",location.getLatitude())
                        .addValue("status",location.getStatus())
                                .addValue("importance_status",location.getIStatus());


        template.update(sql,param);
        return 1;
    }
    @Override
    public Optional<Location> getLocationByName(String name){

        return null;

    }

    @Override
    public Optional<Location> getLocationByImportance(String status) {
        return null;
    }

}
