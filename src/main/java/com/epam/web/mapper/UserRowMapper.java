package com.epam.web.mapper;

import com.epam.web.entities.UserRating;
import com.epam.web.entities.Role;
import com.epam.web.entities.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {

    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";
    private static final String ROLE = "role";
    private static final String RATING = "rating";


    @Override
    public User map(ResultSet resultSet) throws SQLException {
        Long id = resultSet.getLong(ID);
        String name = resultSet.getString(NAME);
        String username = resultSet.getString(USERNAME);
        String password = resultSet.getString(PASSWORD);
        String roleAsString = resultSet.getString(ROLE);
        Role role = Role.valueOf(roleAsString);
        String ratingAsString = resultSet.getString(RATING);
        UserRating userRating = UserRating.valueOf(ratingAsString);

        return new User(id, name, username, password, role, userRating);

    }
}
