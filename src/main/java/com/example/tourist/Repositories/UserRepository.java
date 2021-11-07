package com.example.tourist.Repositories;

import com.example.tourist.Constants.Constants;
import com.example.tourist.Exeptions.EtAuthException;
import com.example.tourist.dao.UserDao;
import com.example.tourist.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Optional;

@Repository("userpsql")
@Transactional
public class UserRepository implements UserDao {

    @Autowired
JdbcTemplate jdbcTemplate;

    @Override
    public String generateJWT(User user) throws EtAuthException {



        long timestamp=System.currentTimeMillis();
        System.out.println(user.getEmail());
        String token= Jwts.builder().signWith(SignatureAlgorithm.HS256, Constants.API_SECURITY_KEY)
                .setIssuedAt(new Date(timestamp))
                .setExpiration(new Date(timestamp+Constants.TOKEN_VALIDITY))
                .claim("email",user.getEmail())
                .claim("id",user.getId())
                .compact();
                return token;
    }

    @Override
    public String validateUser(String email, String password) throws EtAuthException {
        String sql="select email,password from Users where email=?;";
        String token="no token";
        User user = jdbcTemplate.queryForObject(
                sql, new Object[] { email }, userRowMapper);
        System.out.println(user.getEmail());


        if(!BCrypt.checkpw(password,user.getPassword())){
token=this.generateJWT(user);
        }


        return token;
    }

    @Override
    public User registerUser(User user) throws EtAuthException {
       String sql="insert into Users (password,email,created_at) values (?,?,now())";
       
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

    private RowMapper<User> userRowMapper =((rs, rowNum) -> {
        return new User(rs.getString("email"),
                rs.getString("password"),Integer.parseInt(rs.getString("id")));
    });


    public User findUser(String email, String password) throws EtAuthException {
        String sql="select email,password from Users where email=?;";

System.out.println(email);
try {User user = jdbcTemplate.queryForObject(
        sql, new Object[] { email }, userRowMapper);
    System.out.println("user found");
    if(!BCrypt.checkpw(password,user.getPassword())){
        throw new EtAuthException("Invalid email or password!");
    }
    return user;

}catch (Exception e){

    throw new EtAuthException("Invalid email or password!");
}



    }
}
