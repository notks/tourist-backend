package com.example.tourist.Repositories;

import com.example.tourist.dao.LocationDao;
import com.example.tourist.model.Location;
import com.example.tourist.model.User;
import org.springframework.jdbc.core.RowMapper;
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

public class LocationRepository implements LocationDao {

NamedParameterJdbcTemplate template;

    public LocationRepository(NamedParameterJdbcTemplate template) {
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
                .addValue("created_at",new Timestamp(new Date().getTime()))
                .addValue("latitude",location.getLatitude())
                        .addValue("status",location.getStatus())
                                .addValue("importance_status",location.getIStatus());


        template.update(sql,param);
        return 1;
    }
    @Override
    public List<Location> getLocationByName(String name){
        final String sql = "SELECT Locations.*,Cities.\"cityName\" as cityName ,Countries.name as countryName FROM Locations LEFT JOIN Cities ON Locations.city_id = Cities.id LEFT JOIN Countries ON Cities.country_id = Countries.id WHERE Locations.name=:name";
List<Location> locations= new ArrayList<>();

System.out.println("2");
SqlParameterSource param = new MapSqlParameterSource()
                .addValue("name", name);
        locations=template.query(sql,param,locationRowMapper);
        System.out.println(locations);
        return locations;

    }

    private RowMapper<Location> locationRowMapper =((rs, rowNum) -> {
        return new Location(rs.getString("name")
                ,rs.getString("description")
                ,rs.getDouble("longitude")
                ,rs.getDouble("latitude")
                ,rs.getString("status")
                ,rs.getString("importance_status")
                ,rs.getString("cityName")
                ,rs.getString("countryName")
                ,rs.getTimestamp("created_at")
                ,rs.getInt("id")
                );
    });

    @Override
    public Optional<Location> getLocationByImportance(String status) {
        return null;
    }

}
