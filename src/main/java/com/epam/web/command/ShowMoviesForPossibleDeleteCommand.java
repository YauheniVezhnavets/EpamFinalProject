package com.epam.web.command;

import com.epam.web.dao.DaoException;
import com.epam.web.entities.Movie;
import com.epam.web.service.MovieService;
import com.epam.web.service.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ShowMoviesForPossibleDeleteCommand implements Command {

    private MovieService movieService;

    private static final String MOVIES= "movies";
    private static final String ADMIN_PAGE = "/WEB-INF/view/adminDeleteMovies.jsp";

    public ShowMoviesForPossibleDeleteCommand(MovieService movieService) {
        this.movieService = movieService;
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws DaoException, ServiceException {



        List<Movie> movies = movieService.getAllMovies();

        request.getSession().setAttribute(MOVIES,movies);


        return CommandResult.forward(ADMIN_PAGE);

    }

}
