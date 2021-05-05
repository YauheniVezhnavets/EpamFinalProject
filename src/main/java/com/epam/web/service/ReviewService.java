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

//
//    public List<Review> getAllReviews() throws ServiceException {
//
//        try (DaoHelper daoHelper = daoHelperFactory.create()) {
//            ReviewDao reviewDao = daoHelper.createReviewDao();
//            return new ;
//        } catch (DaoException e) {
//            throw new ServiceException(e);
//        }
//    }



}
