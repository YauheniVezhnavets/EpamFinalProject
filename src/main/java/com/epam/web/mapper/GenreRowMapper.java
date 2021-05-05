package com.epam.web.mapper;

import com.epam.web.entities.Genre;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GenreRowMapper implements RowMapper <Genre> {
    private static final String ID = "id";
    private static final String NAME = "name";

    @Override
    public Genre map(ResultSet resultSet) throws SQLException {
        Long id = resultSet.getLong(ID);
        String name = resultSet.getString(NAME);
        return new Genre(id,name);
    }
}
