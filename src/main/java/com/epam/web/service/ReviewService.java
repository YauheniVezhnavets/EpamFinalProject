package com.epam.web.service;

import com.epam.web.dao.*;
import com.epam.web.entities.Movie;
import com.epam.web.entities.Review;

import java.util.List;

public class ReviewService {

    private final DaoHelperFactory daoHelperFactory;


    public ReviewService(DaoHelperFactory daoHelperFactory) {
        this.daoHelperFactory = daoHelperFactory;
    }


    public List<Review> getAllReviewsByMovieId(Long movieId) throws ServiceException {

        try (DaoHelper daoHelper = daoHelperFactory.create()) {
            ReviewDao reviewDao = daoHelper.createReviewDao();
            return reviewDao.getAllReviewsByMovieId(movieId);

        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public void addNewReviewToMovie(String review, Long movieId, Long userId) throws ServiceException {
        try (DaoHelper daoHelper = daoHelperFactory.create()) {
            ReviewDao reviewDao = daoHelper.createReviewDao();
            reviewDao.addNewReviewToMovie(review, movieId, userId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public void deleteReview(Long reviewId) throws ServiceException {
        try (DaoHelper daoHelper = daoHelperFactory.create()) {
            ReviewDao reviewDao = daoHelper.createReviewDao();
            reviewDao.removeMovieReview(reviewId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
