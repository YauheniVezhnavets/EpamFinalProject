package com.epam.web.command;

import com.epam.web.dao.DaoException;
import com.epam.web.entities.Movie;
import com.epam.web.service.MovieService;
import com.epam.web.service.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class DeleteMovieCommand implements Command {

    private MovieService movieService;

    private final static String GET_MOVIES_FOR_POSSIBLE_DELETE = "getMoviesForPossibleDelete";
    private static final String ID= "id";


    public DeleteMovieCommand(MovieService movieService) {
        this.movieService = movieService;
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws DaoException, ServiceException {


        String movieIdAsString =  request.getParameter(ID);
        Long movieId = Long.parseLong(movieIdAsString);



        movieService.removeMovieById(movieId);


        return CommandResult.redirect(GET_MOVIES_FOR_POSSIBLE_DELETE);


    }
}
