package com.epam.web.command;

import com.epam.web.dao.DaoException;
import com.epam.web.entities.Movie;
import com.epam.web.service.MovieService;
import com.epam.web.service.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Optional;

public class ShowMovieCommand implements Command {

    private final MovieService movieService;
    private static final String MOVIE_PAGE = "/WEB-INF/view/movie.jsp";

    private static final String ID= "id";
    private static final String MOVIE = "movie";

    public ShowMovieCommand(MovieService movieService) {
        this.movieService = movieService;
    }


    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws DaoException, ServiceException {


        String idParam =  request.getParameter(ID);
        Long movieId = Long.parseLong(idParam);



        Optional <Movie> optionalMovie = movieService.getMovie(movieId);

        Movie movie = optionalMovie.get();

        request.getSession().setAttribute(MOVIE,movie);

        return CommandResult.forward(MOVIE_PAGE);
    }
}
