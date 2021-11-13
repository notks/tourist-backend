package com.example.tourist.service;

import com.example.tourist.model.City;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public class CityService {
    NamedParameterJdbcTemplate template;

    public CityService(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    public boolean save(String name,int id){
        final String sql = "insert into Cities(\"cityName\",country_id) values(:name,:id)";

        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("name", name).addValue("id",id);
        try {
            template.update(sql,param);
            return true;
        }catch (Exception e){
            return false;
        }

    }
    public List<City> getCities(int id){
        final String sql = "select * from Cities where country_id=:id ";

        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("id",id);

        try {
            return template.query(sql,param,(rs, rowNum) ->new City(rs.getString("cityName"),rs.getInt("country_id"),rs.getInt("id"))

            );
        }catch (Exception e){
            return null;
        }

    }

}
