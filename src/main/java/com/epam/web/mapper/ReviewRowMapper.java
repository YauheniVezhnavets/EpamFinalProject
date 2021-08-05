package com.epam.web.mapper;

import com.epam.web.entities.Review;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class ReviewRowMapper implements RowMapper<Review> {

    private static final String ID = "id";
    private static final String REVIEW = "review";
    private static final String USER_ID = "user_id";
    private static final String MOVIE_ID = "movie_id";


    @Override
    public Review map(ResultSet resultSet) throws SQLException {
        Long id = resultSet.getLong(ID);
        String review = resultSet.getString(REVIEW);
        Long userId = resultSet.getLong(USER_ID);
        Long movieId = resultSet.getLong(MOVIE_ID);

        return new Review(id, review, userId, movieId);
    }
}
