package com.epam.web.command;

import com.epam.web.dao.DaoException;
import com.epam.web.entities.User;
import com.epam.web.service.MovieRatingService;
import com.epam.web.service.MovieService;
import com.epam.web.service.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Optional;

public class AddMovieRatingCommand implements Command {

    private MovieRatingService movieRatingService;

    private static final String ID = "id";
    private static final String SHOW_MOVIE = "movie&id=";
    private static final String MOVIE_PAGE = "/WEB-INF/view/movie.jsp";


    public AddMovieRatingCommand(MovieRatingService movieRatingService) {
        this.movieRatingService = movieRatingService;
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {

        String idParam = request.getParameter(ID);
        long movieId = Long.parseLong(idParam);

        User user = (User) request.getSession().getAttribute("user");
        long userId = user.getId();

        String movieRatingAsString = request.getParameter("rating");
        long movieRating = Long.parseLong(movieRatingAsString);

        if (!movieRatingService.checkRating(movieId, userId)) {
            movieRatingService.rateMovie(movieId, userId, movieRating);
        }
        if (movieRatingService.checkRating(movieId, userId)) {
            request.setAttribute("repeatMessage", true);
            return CommandResult.forward(MOVIE_PAGE);
        }
        return CommandResult.redirect(SHOW_MOVIE + movieId);
    }
}
