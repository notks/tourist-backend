package com.example.tourist.Repositories;

import com.example.tourist.Constants.Constants;
import com.example.tourist.Exeptions.EtAuthException;
import com.example.tourist.dao.UserDao;
import com.example.tourist.model.NewUser;
import com.example.tourist.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.tomcat.util.log.SystemLogHandler;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository("userpsql")
@Transactional
public class UserRepository implements UserDao {

    @Autowired
JdbcTemplate jdbcTemplate;

    @Override
    public String generateJWT(User user) throws EtAuthException {


if(user==null){
    return null;
}
        long timestamp=System.currentTimeMillis();
        return Jwts.builder().signWith(SignatureAlgorithm.HS256, Constants.API_SECURITY_KEY)
                .setIssuedAt(new Date(timestamp))
                .setExpiration(new Date(timestamp+Constants.TOKEN_VALIDITY))
                .claim("email",user.getEmail())
                .claim("id",user.getId())
                .compact();

    }

    @Override
    public String validateUser(String email, String password) throws EtAuthException {
        String sql="select email,password from Users where email=?;";
        String token="no token";
        User user = jdbcTemplate.queryForObject(
                sql, new Object[] { email }, userRowMapper);



        if(!BCrypt.checkpw(password,user.getPassword())){
token=this.generateJWT(user);
        }


        return token;
    }

    @Override
    public NewUser registerUser(NewUser user) throws EtAuthException {
       String sql="insert into Users (password,email,created_at) values (?,?,now())";
        String sql2="select count(*) from Users where email=?;";
        System.out.println(user.getEmail());
        System.out.println(user.getPassword());
        int count=jdbcTemplate.queryForObject(
                sql2, new Object[] { user.getEmail() },Integer.class);
System.out.println(count);
        if( count!=0){
            return null;
        }
       System.out.println(user.getEmail());
        System.out.println(user.getPassword());
         jdbcTemplate.update(
                sql, BCrypt.hashpw(user.getPassword(),BCrypt.gensalt(10)),user.getEmail());
        return user;
    }

    @Override
    public int updatePassword(User user, String newPwd) throws EtAuthException {
        return 0;
    }

    @Override
    public int updateEmail(User user, String newEmail) throws EtAuthException {
        return 0;
    }

    private final RowMapper<User> userRowMapper =((rs, rowNum) -> {
        return new User(rs.getString("email"),
                rs.getString("password"),Integer.parseInt(rs.getString("id")));
    });


    public User findUser(String email, String password) throws EtAuthException {
        String sql = "select email,password,id from Users where email=?;";
        String sql2="select count(*) from Users where email=?;";
        System.out.println("finding user...");

        int count=jdbcTemplate.queryForObject(
                sql2, new Object[] { email},Integer.class);

        if(count<1){
            System.out.println("No user found");
            return null;
            }
        User user = jdbcTemplate.queryForObject(
                sql, new Object[]{email}, userRowMapper);
        if (BCrypt.checkpw(password, user.getPassword())) {
            System.out.println("user found");
            return user;


        }

        System.out.println("NO MATCHING PW");
        return null;

    }
}
