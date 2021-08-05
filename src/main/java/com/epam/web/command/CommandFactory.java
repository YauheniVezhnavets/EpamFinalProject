package com.epam.web.command;


import com.epam.web.dao.DaoHelperFactory;
import com.epam.web.service.*;

public class CommandFactory {

    private final static String LOGIN = "login";
    private final static String MAIN = "mainPage";
    private final static String ABOUT = "about";
    private final static String LOGOUT = "logout";
    private final static String MOVIES = "movies";
    private final static String MOVIE = "movie";
    private final static String RATING = "rating";
    private final static String CHANGE_LANGUAGE = "changeLanguage";
    private final static String MOVIES_BY_GENRE = "moviesByGenre";
    private final static String GET_USERS = "getUsers";
    private final static String ADD_MOVIE = "addMovie";
    private final static String ADD_MOVIE_PAGE = "addMoviePage";
    private final static String GET_MOVIES_FOR_POSSIBLE_DELETE = "getMoviesForPossibleDelete";
    private final static String DELETE_MOVIE = "deleteMovie";
    private final static String CHANGE_USER_RATING = "changeUserRating";
    private final static String ADD_REVIEW_TO_MOVIE = "addReviewToMovie";
    private final static String PAGE_ACTION = "pageAction";
    private final static String ADD_MOVIE_RATING_COMMAND = "addMovieRating";

    private static final String MAIN_PAGE = "/WEB-INF/view/main.jsp";
    private static final String ABOUT_PAGE = "/WEB-INF/view/about.jsp";
    private static final String ADMIN_ADD_PAGE = "/WEB-INF/view/adminAddMovie.jsp";

    DaoHelperFactory daoHelperFactory = new DaoHelperFactory();

    public Command create(String type) {
        switch (type) {
            case LOGIN:
                return new LoginCommand(new UserService(daoHelperFactory));
            case CHANGE_LANGUAGE:
                return new ChangeLanguageCommand();
            case MAIN:
                return new ShowPageCommand(MAIN_PAGE);
            case ABOUT:
                return new ShowPageCommand(ABOUT_PAGE);
            case ADD_MOVIE_PAGE:
                return new ShowPageCommand(ADMIN_ADD_PAGE);
            case GET_USERS:
                return new GetUsersCommand(new UserService(daoHelperFactory));
            case MOVIES:
                return new ShowMoviesCommand(new MovieService(daoHelperFactory));
            case PAGE_ACTION:
                return new PageActionCommand(new MovieService(daoHelperFactory));
            case MOVIE:
                return new ShowMovieCommand(new MovieService(daoHelperFactory));
            case RATING:
                return new GetUserCommand(new UserService(daoHelperFactory));
            case CHANGE_USER_RATING:
                return new ChangeUserRating(new UserService(daoHelperFactory));
            case MOVIES_BY_GENRE:
                return new ShowMoviesByGenreCommand(new MovieService(daoHelperFactory));
            case ADD_MOVIE:
                return new AddMovieCommand(new MovieService(daoHelperFactory), new GenreService(daoHelperFactory));
            case ADD_MOVIE_RATING_COMMAND:
                return new AddMovieRatingCommand(new MovieRatingService(daoHelperFactory));
            case GET_MOVIES_FOR_POSSIBLE_DELETE:
                return new ShowMoviesForPossibleDeleteCommand(new MovieService(daoHelperFactory));
            case DELETE_MOVIE:
                return new DeleteMovieCommand(new MovieService(daoHelperFactory));
            case ADD_REVIEW_TO_MOVIE:
                return new ReviewMovieCommand(new ReviewService(daoHelperFactory));
            case LOGOUT:
                return new LogoutCommand();
            default:
                throw new IllegalArgumentException("Unknown type ofCommand " + type);
        }
    }
}
