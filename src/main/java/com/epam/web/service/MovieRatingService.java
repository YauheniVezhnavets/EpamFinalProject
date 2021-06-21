package com.epam.web.service;

import com.epam.web.dao.DaoException;
import com.epam.web.dao.DaoHelper;
import com.epam.web.dao.DaoHelperFactory;
import com.epam.web.dao.MovieRatingDao;


public class MovieRatingService {

    private final DaoHelperFactory daoHelperFactory;

    public MovieRatingService(DaoHelperFactory daoHelperFactory) {
        this.daoHelperFactory = daoHelperFactory;
    }

    public void rateMovie(long movieId, long userId, double movieRating) throws ServiceException {
        try (DaoHelper daoHelper = daoHelperFactory.create()) {
            MovieRatingDao movieRatingDao = daoHelper.createMovieRatingDao();
            movieRatingDao.addRating(movieId,userId,movieRating);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    public boolean checkRating(long movieId, long userId) throws ServiceException {
        try (DaoHelper daoHelper = daoHelperFactory.create()) {
            MovieRatingDao movieRatingDao = daoHelper.createMovieRatingDao();
             return movieRatingDao.hasRating(movieId,userId);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    public double getMovieRating(long movieId) throws ServiceException {
        try (DaoHelper daoHelper = daoHelperFactory.create()) {
            MovieRatingDao movieRatingDao = daoHelper.createMovieRatingDao();
            return movieRatingDao.getMovieRating(movieId);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }
}
