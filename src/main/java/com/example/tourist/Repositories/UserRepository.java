package com.example.tourist.Repositories;

import com.example.tourist.Exeptions.EtAuthException;
import com.example.tourist.dao.UserDao;
import com.example.tourist.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository("userpsql")
@Transactional
public class UserRepository implements UserDao {

    @Autowired
JdbcTemplate jdbcTemplate;
    @Override
    public User validateUser(String email, String password) throws EtAuthException {
        String sql="select email,password from Users where password=?;";
        User user = jdbcTemplate.queryForObject(
                sql, new Object[] { password }, userRowMapper);
        return user;
    }

    @Override
    public User registerUser(User user) throws EtAuthException {
       String sql="insert into Users (password,email,created_at) values (?,?,now())";
       
       System.out.println(user.getEmail());
        System.out.println(user.getPassword());
         jdbcTemplate.update(
                sql, user.getPassword(),user.getEmail());
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
                rs.getString("password"));
    });
}
