package com.epam.web.mapper;

import com.epam.web.entities.Movie;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MovieRowMapper implements RowMapper<Movie> {

    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String PATH_TO_IMAGE = "path_to_image";
    private static final String DESCRIPTION = "description";
    private static final String GENRE_ID = "genre_id";



    @Override
    public Movie map(ResultSet resultSet) throws SQLException {
        Long id = resultSet.getLong(ID);
        String name = resultSet.getString(NAME);
        String pathToImage = resultSet.getString(PATH_TO_IMAGE);
        String  description = resultSet.getString(DESCRIPTION);
        Long genreId = resultSet.getLong(GENRE_ID);

        return new Movie(id,name,pathToImage,description,genreId);

    }
}
