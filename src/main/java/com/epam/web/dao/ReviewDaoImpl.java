package com.epam.web.dao;

import com.epam.web.entities.Review;
import com.epam.web.mapper.ReviewRowMapper;

import java.sql.Connection;
import java.util.List;


public class ReviewDaoImpl extends AbstractDao<Review>  implements ReviewDao {

    private static final String TABLE_NAME = "reviews";
    private static final String INSERT_REVIEW = "INSERT INTO reviews (user_id, movie_id, review) VALUES (?, ?, ?)";
    private static final String GET_REVIEWS_BY_MOVIE_ID = "SELECT * FROM reviews " +
            "INNER JOIN user ON movie.user_id = user.id " +
            "WHERE movie_id = ?";
    private static final String REMOVE_BY_MOVIE_ID = "DELETE FROM reviews WHERE movie_id = ?";



    public ReviewDaoImpl(Connection connection) {
        super(connection, new ReviewRowMapper(), TABLE_NAME);

    }


    @Override
    public List<Review> getMovieReviews(Long movieId) throws DaoException {
        return executeQuery(GET_REVIEWS_BY_MOVIE_ID,movieId);
    }

    @Override
    public void removeMovieReview(Long filmId) throws DaoException {
        executeUpdate(REMOVE_BY_MOVIE_ID,filmId);
    }


    @Override
    public void save(Review item) throws DaoException {
        executeUpdate(INSERT_REVIEW, item.getUserId(),item.getMovieId(),item.getReview());

    }

}
