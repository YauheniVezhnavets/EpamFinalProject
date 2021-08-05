package com.epam.web.dao;

import com.epam.web.entities.Review;

import java.util.List;
import java.util.Optional;

/**
 * ReviewDao provides functionality for interaction with storage,
 * which contains data about {@link Review} entities
 *
 * @see Dao
 * @author Yauheni Vezhnavets
 */

public interface ReviewDao extends Dao<Review> {

    /**
     * Loads all reviews for specified film
     * @param movieId id for the movie, for which reviews will be loaded
     * @return List of all reviews are related with specified movie.
     * If there is no reviews about movie, an empty List will be returned
     * @throws DaoException if request to the storage is invalid
     */

    List<Review> getAllReviewsByMovieId(Long movieId) throws DaoException;

    /**
     * Adds a new review record to the storage
     * @param movieId id of the movie, dedicated to review
     * @param userId id of user, which is review author
     * @param review content of review
     * @throws DaoException if request to the storage is invalid
     */

    void addNewReviewToMovie(String review, Long movieId, Long userId) throws DaoException;

    /**
     * Removes all reviews, which are related to this movie
     * @param moveId id of movie, which matches the record in the storage.
     * @throws DaoException if request to storage is corrupted
     */

    void removeMovieReview(Long moveId) throws DaoException;
}
