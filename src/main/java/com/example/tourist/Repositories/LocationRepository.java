package com.example.tourist.Repositories;

import com.example.tourist.dao.LocationDao;
import com.example.tourist.model.Location;
import com.example.tourist.model.NewLocation;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

import java.util.Date;
import java.util.List;
@Repository("postgres")

public class LocationRepository implements LocationDao {

NamedParameterJdbcTemplate template;

    public LocationRepository(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    @Override
    public boolean insertLocation(NewLocation location){
        final String sql = "insert into Locations(name, country_id , description,longitude,latitude,created_at,status,importance_status,city_id) values(:name, :country_id , :description,:longitude,:latitude,:created_at,:status,:importance_status,:city_id)";

        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("name", location.getName())
                .addValue("country_id", location.getCountry_id())
                .addValue("city_id", location.getCity_id())
                .addValue("description", location.getDescription())
                .addValue("longitude",location.getLongitude())
                .addValue("created_at",new Timestamp(new Date().getTime()))
                .addValue("latitude",location.getLatitude())
                .addValue("status","inactive")
                .addValue("importance_status",location.getIStatus());

try {
    template.update(sql,param);
    return true;

}catch (Exception e){
return false;
}
    }
    @Override
    public List<Location> getLocationByName(String name){
        final String sql = "SELECT Locations.*,Cities.\"cityName\" as cityName ,Countries.name as countryName FROM Locations LEFT JOIN Cities ON Locations.city_id = Cities.id LEFT JOIN Countries ON Cities.country_id = Countries.id WHERE Locations.name=:name and Locations.status='active'";


SqlParameterSource param = new MapSqlParameterSource().addValue("name", name);
        return template.query(sql,param,locationRowMapper);

    }

    private final RowMapper<Location> locationRowMapper =((rs, rowNum) -> new Location(rs.getString("name")
            ,rs.getString("description")
            ,rs.getDouble("longitude")
            ,rs.getDouble("latitude")
            ,rs.getString("status")
            ,rs.getString("importance_status")
            ,rs.getString("cityName")
            ,rs.getString("countryName")
            ,rs.getTimestamp("created_at")
            ,rs.getInt("id")
            ));

    @Override
    public List<Location> getLocationByImportance(String status) {
        final String sql = "SELECT Locations.*,Cities.\"cityName\" as cityName ,Countries.name as countryName FROM Locations LEFT JOIN Cities ON Locations.city_id = Cities.id LEFT JOIN Countries ON Cities.country_id = Countries.id WHERE Locations.importance_status=:status and Locations.status='active'";
        SqlParameterSource param = new MapSqlParameterSource().addValue("status",status);

        return template.query(sql,param,locationRowMapper);
    }

    @Override
    public List<Location> getAllLocations() {
        final String sql = "SELECT Locations.*,Cities.\"cityName\" as cityName ,Countries.name as countryName FROM Locations LEFT JOIN Cities ON Locations.city_id = Cities.id LEFT JOIN Countries ON Cities.country_id = Countries.id;";

        return template.query(sql,locationRowMapper);
    }

    @Override
    public List<Location> getAllActiveLocations() {
        final String sql = "SELECT Locations.*,Cities.\"cityName\" as cityName ,Countries.name as countryName FROM Locations LEFT JOIN Cities ON Locations.city_id = Cities.id LEFT JOIN Countries ON Cities.country_id = Countries.id where Locations.status='active'";

        return template.query(sql,locationRowMapper);
    }

    @Override
    public boolean removeLocation(int id) {

        String sql="delete from Locations where id=:id";
        String sql2="delete from Ratings where location_id=:id";
        String sql3="delete from Pictures where location_id=:id";
        try {
            SqlParameterSource param = new MapSqlParameterSource().addValue("id",id);
            template.update(sql3,param);
            template.update(sql2,param);
            template.update(sql,param);

            return true;

        }catch (Exception e){
return false;
        }
    }

    @Override
    public boolean activate(int id) {
        String sql="update  Locations set status='active' where id=:id;";

        SqlParameterSource param = new MapSqlParameterSource().addValue("id",id);

        template.update(sql,param);
        return true;
    }

    @Override
    public boolean deactivate(int id) {
        String sql="update  Locations set status='inactive' where id=:id;";

        SqlParameterSource param = new MapSqlParameterSource().addValue("id",id);

        template.update(sql,param);
        return true;
    }
}
