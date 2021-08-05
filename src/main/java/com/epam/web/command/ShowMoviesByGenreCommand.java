package com.epam.web.command;

import com.epam.web.dto.MovieDto;
import com.epam.web.entities.Movie;
import com.epam.web.service.MovieService;
import com.epam.web.service.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class ShowMoviesByGenreCommand implements Command {
    private static final String MOVIES = "movies";
    private static final String MOVIES_PAGE = "/WEB-INF/view/movies.jsp";

    private static final String GENRE = "genre";

    private MovieService movieService;

    public ShowMoviesByGenreCommand(MovieService movieService) {
        this.movieService = movieService;
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {

        String genre = request.getParameter(GENRE);
        List<MovieDto> moviesByGenre = movieService.getAllMoviesByGenre(genre);

        HttpSession session = request.getSession();
        session.setAttribute(MOVIES, moviesByGenre);

        return CommandResult.forward(MOVIES_PAGE);
    }
}
