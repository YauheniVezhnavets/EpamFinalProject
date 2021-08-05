package com.epam.web.command;

import com.epam.web.dao.DaoException;
import com.epam.web.dto.MovieDto;
import com.epam.web.entities.Movie;
import com.epam.web.service.MovieService;
import com.epam.web.service.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class ShowMoviesCommand implements Command {

    private static final String MOVIES = "movies";
    private static final String PAGINATION_LIST = "paginationList";
    private final static String CURRENT_PAGE = "currentPage";
    private static final String MOVIES_PAGE = "/WEB-INF/view/movies.jsp";

    private final MovieService movieService;

    public ShowMoviesCommand(MovieService movieService) {
        this.movieService = movieService;
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {

        String pageAsString = (String) request.getSession().getAttribute("page");
        int numberOfPage = Integer.parseInt(pageAsString);
        List<MovieDto> movies = movieService.getMoviesForPage(numberOfPage);
        List<Integer> paginationList = movieService.getPaginationList();

        HttpSession session = request.getSession();

        session.setAttribute(MOVIES, movies);
        session.setAttribute(PAGINATION_LIST, paginationList);
        session.setAttribute(CURRENT_PAGE, MOVIES_PAGE);

        return CommandResult.forward(MOVIES_PAGE);
    }
}
