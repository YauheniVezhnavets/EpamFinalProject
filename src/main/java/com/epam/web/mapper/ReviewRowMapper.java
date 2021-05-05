package com.epam.web.mapper;

import com.epam.web.entities.Review;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReviewRowMapper implements RowMapper<Review> {

    private static final String ID = "id";
    private static final String USER_ID = "user_id";
    private static final String MOVIE_ID = "movie_id";
    private static final String REVIEW = "review";




    @Override
    public Review map(ResultSet resultSet) throws SQLException {
        Long id = resultSet.getLong(ID);
        Long userId = resultSet.getLong(USER_ID);
        Long  movieId = resultSet.getLong(MOVIE_ID);
        String review = resultSet.getString(REVIEW);

        return new Review(id,userId,movieId,review);
    }
}
