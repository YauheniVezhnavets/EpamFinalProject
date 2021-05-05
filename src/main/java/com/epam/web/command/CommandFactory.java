package com.epam.web.command;


import com.epam.web.dao.DaoHelperFactory;
import com.epam.web.service.MovieService;
import com.epam.web.service.UserService;

public class CommandFactory {

    private final static String LOGIN = "login";
    private final static String INVALID_LOGIN = "invalidLogin";
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






    private static final String MAIN_PAGE = "/WEB-INF/view/main.jsp";
    private static final String INDEX_PAGE = "/index.jsp";
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
            case INVALID_LOGIN:
                return new ShowPageCommand(INDEX_PAGE);
            case ABOUT:
                return new ShowPageCommand(ABOUT_PAGE);
            case ADD_MOVIE_PAGE:
                return new ShowPageCommand(ADMIN_ADD_PAGE);
            case GET_USERS:
                return new GetUsersCommand(new UserService(daoHelperFactory));
            case MOVIES:
                return new ShowMoviesCommand(new MovieService(daoHelperFactory));
            case MOVIE:
                return new ShowMovieCommand(new MovieService(daoHelperFactory));
            case RATING:
                return new GetUserCommand(new UserService(daoHelperFactory));
            case CHANGE_USER_RATING:
                return new ChangeUserRating(new UserService(daoHelperFactory));
            case MOVIES_BY_GENRE:
                return new ShowMoviesByGenreCommand(new MovieService(daoHelperFactory));
            case ADD_MOVIE:
                return new AddMovieCommand(new MovieService(daoHelperFactory));
            case GET_MOVIES_FOR_POSSIBLE_DELETE:
                return new ShowMoviesForPossibleDeleteCommand(new MovieService(daoHelperFactory));
            case DELETE_MOVIE:
                return new DeleteMovieCommand(new MovieService(daoHelperFactory));
            case LOGOUT:
                return new LogoutCommand();
            default:
                throw  new IllegalArgumentException("Unknown type ofCommand " + type);
        }
    }
}
