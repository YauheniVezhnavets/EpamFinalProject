package com.epam.web.dao;

import com.epam.web.entities.MovieRating;

import java.util.List;


public interface MovieRatingDao extends Dao <MovieRating> {

    void addRating(long movieId, long userId, double movieRating) throws DaoException;

    boolean hasRating(long movieId, long userId) throws DaoException;

    double getMovieRating(long movieId) throws DaoException;

    void removeFilmsRatings(long movieId) throws DaoException;

    List<MovieRating> movieHasRating(long movieId) throws DaoException;

}
