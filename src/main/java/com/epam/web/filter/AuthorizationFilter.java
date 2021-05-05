package com.epam.web.filter;

import com.epam.web.entities.Role;
import com.epam.web.entities.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

public class AuthorizationFilter implements Filter  {
    private final Map<String, List <Role>> roleMap = new HashMap<>();
    private final static String LOGIN = "login";
    private final static String INVALID_LOGIN = "invalidLogin";
    private final static String LOGOUT = "logout";
    private final static String MAIN = "mainPage";
    private final static String ABOUT = "about";
    private final static String MOVIES = "movies";
    private final static String MOVIE = "movie";
    private final static String CHOOSE_MOVIE = "chooseMovie";
    private final static String RATING = "rating";
    private final static String CHANGE_LANGUAGE = "changeLanguage";
    private final static String MOVIES_BY_GENRE = "moviesByGenre";
    private final static String GET_USERS = "getUsers";
    private final static String ADD_MOVIE = "addMovie";
    private final static String ADD_MOVIE_PAGE = "addMoviePage";
    private final static String DELETE_MOVIE = "deleteMovie";
    private final static String CHANGE_USER_RATING = "changeUserRating";
    private final static String GET_MOVIES_FOR_POSSIBLE_DELETE = "getMoviesForPossibleDelete";




    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        roleMap.put(INVALID_LOGIN, Arrays.asList(Role.USER, Role.ADMIN, Role.UNKNOWN));
        roleMap.put(LOGIN, Arrays.asList(Role.USER, Role.ADMIN, Role.UNKNOWN));
        roleMap.put(CHANGE_LANGUAGE, Arrays.asList(Role.USER, Role.ADMIN, Role.UNKNOWN));

        roleMap.put(LOGOUT, Arrays.asList(Role.USER, Role.ADMIN ));
        roleMap.put(MAIN, Arrays.asList(Role.USER, Role.ADMIN ));
        roleMap.put(ABOUT, Collections.singletonList(Role.USER));
        roleMap.put(MOVIES, Collections.singletonList(Role.USER));
        roleMap.put(MOVIE, Collections.singletonList(Role.USER));
        roleMap.put(RATING, Collections.singletonList(Role.USER));
        roleMap.put(CHOOSE_MOVIE, Collections.singletonList(Role.USER));
        roleMap.put(MOVIES_BY_GENRE, Collections.singletonList(Role.USER));
        roleMap.put(GET_USERS, Collections.singletonList(Role.ADMIN));
        roleMap.put(CHANGE_USER_RATING, Collections.singletonList(Role.ADMIN));
        roleMap.put(ADD_MOVIE, Collections.singletonList(Role.ADMIN));
        roleMap.put(DELETE_MOVIE, Collections.singletonList(Role.ADMIN));
        roleMap.put(GET_MOVIES_FOR_POSSIBLE_DELETE, Collections.singletonList(Role.ADMIN));
        roleMap.put(ADD_MOVIE_PAGE, Collections.singletonList(Role.ADMIN));





    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String command = request.getParameter("command");
        boolean exist = roleMap.containsKey(command);


        if (exist) {
              User user = (User) request.getSession().getAttribute("user");
              Role userRole = user != null ? user.getRole() : Role.UNKNOWN;


               List<Role> roles = roleMap.get(command);
               boolean validCommand = roles.contains(userRole);

            if (!validCommand) {
                RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
                dispatcher.forward(servletRequest, servletResponse);
            }
       }
        else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
            dispatcher.forward(servletRequest, servletResponse);
        }

        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
