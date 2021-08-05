package com.epam.web.dao;


import com.epam.web.entities.MovieRating;
import com.epam.web.mapper.MovieRatingRowMapper;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public class MovieRatingDaoImpl extends AbstractDao<MovieRating> implements MovieRatingDao {

    private static final String RATING_COLUMN = "Average_Rating";
    public static final String TABLE_NAME = "movieratings";
    private static final String ADD_MOVIE_RATING = "INSERT INTO movieratings(movie_id,user_id, Rating) VALUES (?, ?, ?)";
    private static final String FIND_RATING = "SELECT * FROM movieratings WHERE movie_id = ? AND user_id = ?";
    private static final String FIND_MOVIE_RATING = "SELECT * FROM movieratings WHERE movie_id = ?";
    private static final String GET_AVG_RATING = "SELECT AVG(Rating) AS Average_Rating FROM movieratings WHERE movie_id = ?";
    private static final String DELETE_BY_MOVIE_ID = "DELETE FROM movieratings WHERE movie_id = ?";

    public MovieRatingDaoImpl(Connection connection) {
        super(connection, new MovieRatingRowMapper(), TABLE_NAME);

    }

    @Override
    public void addRating(long movieId, long userId, double movieRating) throws DaoException {
            executeUpdate(ADD_MOVIE_RATING, movieId, userId, movieRating);
    }

    @Override
    public boolean hasRating(long movieId, long userId) throws DaoException {
        Optional<MovieRating> rating = executeForSingleResult(FIND_RATING, movieId, userId);
        return  rating.isPresent();
    }

    @Override
    public List <MovieRating> movieHasRating(long movieId) throws DaoException {
        return executeQuery(FIND_MOVIE_RATING, movieId);
    }

    @Override
    public double getMovieRating(long movieId) throws DaoException {
        return executeAvg(GET_AVG_RATING, RATING_COLUMN, movieId);
    }

    @Override
    public void removeFilmsRatings(long movieId) throws DaoException {
        executeUpdate(DELETE_BY_MOVIE_ID, movieId);
    }
}
