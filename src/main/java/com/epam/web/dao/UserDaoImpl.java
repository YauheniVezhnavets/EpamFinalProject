package com.epam.web.dao;

import com.epam.web.entities.Movie;
import com.epam.web.entities.Role;
import com.epam.web.entities.User;
import com.epam.web.mapper.UserRowMapper;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public class UserDaoImpl extends AbstractDao<User> implements UserDao {

    public static final String TABLE_NAME = "users";
    private static final String FIND_BY_USERNAME_AND_PASSWORD = "select * from movies_database.USER WHERE USERNAME =?  AND PASSWORD = MD5(?)";
    private static final String SELECT_ALL_CLIENTS = "SELECT * FROM movies_database.user WHERE role = 'user'";
    private static final String FIND_BY_ID = "select * from movies_database.USER WHERE id =?";
    private static final String UPDATE_USER_RATING = "UPDATE movies_database.user SET rating = ? WHERE id = ?";

    public UserDaoImpl(Connection connection) {
        super(connection, new UserRowMapper(), TABLE_NAME);
    }

    @Override
    public Optional<User> findUserByLoginAndPassword(String username, String password) throws DaoException {
        return executeForSingleResult(FIND_BY_USERNAME_AND_PASSWORD, username, password);
    }

    @Override
    public Optional<User> findUserById(Long id) throws DaoException {
        return executeForSingleResult(FIND_BY_ID, id);
    }

    @Override
    public List<User> getAll() throws DaoException {
        return executeQuery(SELECT_ALL_CLIENTS);
    }

    public void updateUserRatingById(String userRating, Long id) throws DaoException {
        executeUpdate(UPDATE_USER_RATING, userRating, id);
    }
}
