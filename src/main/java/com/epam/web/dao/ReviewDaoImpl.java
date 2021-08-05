package com.epam.web.dao;

import com.epam.web.entities.Review;
import com.epam.web.mapper.ReviewRowMapper;

import java.sql.Connection;
import java.util.List;


public class ReviewDaoImpl extends AbstractDao<Review> implements ReviewDao {

    private static final String TABLE_NAME = "reviews";
    private static final String INSERT_REVIEW = "INSERT INTO reviews (review, movie_id, user_id) VALUES (?, ?, ?)";
    private static final String GET_REVIEWS_BY_MOVIE_ID = "SELECT * FROM reviews INNER JOIN user ON user_id = user.id " +
            " where movie_id = ? ";
    private static final String REMOVE_BY_MOVIE_ID = "DELETE FROM reviews WHERE id = ?";


    public ReviewDaoImpl(Connection connection) {
        super(connection, new ReviewRowMapper(), TABLE_NAME);
    }

    @Override
    public List<Review> getAllReviewsByMovieId(Long movieId) throws DaoException {
        return executeQuery(GET_REVIEWS_BY_MOVIE_ID, movieId);
    }

    @Override
    public void removeMovieReview(Long filmId) throws DaoException {
        executeUpdate(REMOVE_BY_MOVIE_ID, filmId);
    }

    public void addNewReviewToMovie(String review, Long movieId, Long userId) throws DaoException {
        executeUpdate(INSERT_REVIEW, review, movieId, userId);
    }
}
