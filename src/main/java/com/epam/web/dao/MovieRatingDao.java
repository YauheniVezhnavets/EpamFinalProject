package com.epam.web.dao;

import com.epam.web.entities.MovieRating;

import java.util.List;

/**
 * MovieRatingDao provides functionality for interaction with storage,
 * which contains data about {@link MovieRating} entities
 *
 * @see Dao
 * @author Yauheni Vezhnavets
 */

public interface MovieRatingDao extends Dao <MovieRating> {

    /**
     * Add a new record for specified rating into the storage
     * @param movieId id of the movie, which matches the record in the storage
     * @param userId id of the user, which matches the record in the storage
     * @param movieRating rating instance, needed to be saved
     * @throws DaoException is request to storage is corrupted
     */

    void addRating(long movieId, long userId, double movieRating) throws DaoException;

    /**
     * Checks if storage contains record for specified movieId and user Id
     * @param movieId id from movies storage, which defines record about movie
     * @param userId id from users storage, which defines record about user
     * @return true is storage contains record for specified parameters,
     * false if there is no record for specified parameters
     * @throws DaoException if request to storage is corrupted
     */

    boolean hasRating(long movieId, long userId) throws DaoException;

    /**
     * Counts the average rating for specified movie
     * @param movieId from movies storage, which defines record about movie
     * @return average value of all ratings for specified movie.
     * If movie has no ratings result will be 0.
     * @throws DaoException if there is no movie with specified id or
     * request to storage is corrupted
     */

    double getMovieRating(long movieId) throws DaoException;

    /**
     * Removes all ratings connected with specified movie
     * @param movieId id of movie, for which ratings records needed to be deleted.
     * @throws DaoException if request to storage is corrupted
     */

    void removeFilmsRatings(long movieId) throws DaoException;


    /**
     * Find all ratings are related with specified movie
     * @param movieId id of movie, for which ratings records needed to be deleted.
     * @throws DaoException if request to storage is corrupted
     */

    List<MovieRating> movieHasRating(long movieId) throws DaoException;

}
