package com.epam.web.mapper;



import com.epam.web.entities.MovieRating;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MovieRatingRowMapper implements RowMapper<MovieRating> {

    private static final String ID = "id";
    private static final String USER_ID = "user_id";
    private static final String MOVIE_ID = "movie_id";
    private static final String MOVIE_RATING = "Rating";




    @Override
    public MovieRating map(ResultSet resultSet) throws SQLException {
        long id = resultSet.getLong(ID);
        long movieId = resultSet.getLong(MOVIE_ID);
        long userId = resultSet.getLong(USER_ID);
        double movieRating = (double) resultSet.getLong(MOVIE_RATING);


        return new MovieRating(id,movieId,userId,movieRating);
    }
}
