package com.epam.web.command;

import com.epam.web.dao.DaoException;
import com.epam.web.service.ServiceException;
import com.epam.web.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;


public class ChangeUserRating implements Command {

    private final UserService userService;

    private static final String USER_RATING = "userRating";
    private static final String ID = "id";
    private static final String GET_USERS = "getUsers";

    public ChangeUserRating(UserService userService) {
        this.userService = userService;
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {

        String userIdAsString = request.getParameter(ID);
        Long userId = Long.parseLong(userIdAsString);

        String userRating = request.getParameter(USER_RATING);

        userService.updateUserRating(userRating, userId);

        return CommandResult.redirect(GET_USERS);
    }
}
