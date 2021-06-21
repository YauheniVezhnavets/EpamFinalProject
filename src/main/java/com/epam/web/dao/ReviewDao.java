package com.epam.web.dao;

import com.epam.web.entities.Review;

import java.util.List;
import java.util.Optional;

public interface ReviewDao extends Dao<Review> {

    List<Review> getAllReviewsByMovieId(Long movieId) throws DaoException;

    void addNewReviewToMovie(String review, Long movieId, Long userId) throws DaoException;

    void removeMovieReview(Long moveId) throws DaoException;
}
