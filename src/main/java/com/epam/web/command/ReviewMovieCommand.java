package com.epam.web.command;

import com.epam.web.dao.DaoException;
import com.epam.web.entities.User;
import com.epam.web.service.ReviewService;
import com.epam.web.service.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ReviewMovieCommand implements Command {

    private static final String SHOW_MOVIE = "movie&id=";

    private final ReviewService reviewService;

    public ReviewMovieCommand(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws DaoException, ServiceException {
        HttpSession session = request.getSession();
        String movieIdAsString = request.getParameter("movieId");
        long movieId = Long.parseLong(movieIdAsString);
        User user = (User) session.getAttribute("user");
        long userId = user.getId();
        String review = request.getParameter("review");
        reviewService.addNewReviewToMovie(review, movieId, userId);
        return CommandResult.redirect(SHOW_MOVIE + movieId);
    }
}
