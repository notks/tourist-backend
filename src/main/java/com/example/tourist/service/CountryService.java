package com.example.tourist.service;

import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public class CountryService {
    NamedParameterJdbcTemplate template;

    public CountryService(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    public boolean save(String name){
        final String sql = "insert into Countries(name) values(:name)";


        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("name", name);
        try {
            template.update(sql,param);
return true;
        }catch (Exception e){
return false;
        }

    }
    public List<String> getAllCountries(){
        final String sql = "select * from Countries;";



        try {
            return template.query(sql,(rs, rowNum) ->
                    rs.getString("name")
            );
        }catch (Exception e){
            return null;
        }

    }

}
