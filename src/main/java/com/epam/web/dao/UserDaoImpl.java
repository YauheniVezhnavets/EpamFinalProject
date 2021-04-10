package com.epam.web.dao;

import com.epam.web.entities.User;
import com.epam.web.mapper.UserRowMapper;

import java.sql.Connection;
import java.util.Optional;

public class UserDaoImpl extends AbstractDao<User> implements UserDao {


    private static final String FIND_BY_USERNAME_AND_PASSWORD = "select ID, NAME from movies_database.USER WHERE USERNAME =?  AND PASSWORD = MD5(?)";


    public UserDaoImpl(Connection connection) {
        super(connection, new UserRowMapper());
    }

    @Override
    public Optional<User> findUserByLoginAndPassword(String username, String password) throws DaoException {
        return executeForSingleResult (FIND_BY_USERNAME_AND_PASSWORD,username,password);
    }
}
