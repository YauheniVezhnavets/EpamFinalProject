package com.epam.web.command;

import com.epam.web.dao.DaoException;
import com.epam.web.entities.Movie;
import com.epam.web.service.MovieService;
import com.epam.web.service.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ShowMoviesCommand implements Command {

    private static final String MOVIES= "movies";
  //  private static final String SHOW_MOVIES = "showMovies";
    private static final String MOVIES_PAGE = "/WEB-INF/view/movies.jsp";


    private final MovieService movieService;


    public ShowMoviesCommand(MovieService movieService) {
        this.movieService = movieService;
    }


    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        List<Movie> movies = movieService.getAllMovies();

        request.getSession().setAttribute(MOVIES,movies);
      //  request.setAttribute(SHOW_MOVIES,true);

        return CommandResult.forward(MOVIES_PAGE);
    }
}
