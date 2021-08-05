package com.epam.web.command;

import com.epam.web.dto.MovieDto;
import com.epam.web.entities.Movie;
import com.epam.web.service.MovieService;
import com.epam.web.service.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class PageActionCommand implements Command {

    private static final String MOVIES = "movies";
    private static final String MOVIES_PAGE = "/WEB-INF/view/movies.jsp";

    private final MovieService movieService;

    public PageActionCommand(MovieService movieService) {
        this.movieService = movieService;
    }


    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {

        String numberOfPageAsPage = request.getParameter("page");
        int numberOfPage = Integer.parseInt(numberOfPageAsPage);
        int pageFromDb = numberOfPage - 1;

        List<MovieDto> movies = movieService.getMoviesForPage(pageFromDb);

        request.getSession().setAttribute(MOVIES, movies);

        return CommandResult.forward(MOVIES_PAGE);
    }
}
