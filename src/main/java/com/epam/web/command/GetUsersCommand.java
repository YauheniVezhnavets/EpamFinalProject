package com.epam.web.command;

import com.epam.web.dao.DaoException;
import com.epam.web.entities.User;
import com.epam.web.service.ServiceException;
import com.epam.web.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class GetUsersCommand implements Command {

    private  final UserService userService;
    private static final String USERS= "users";
    private static final String USERS_PAGE = "/WEB-INF/view/users.jsp";


    public GetUsersCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws DaoException, ServiceException {

        List<User> users = userService.getAllUsers();

        request.getSession().setAttribute(USERS,users);

        return CommandResult.forward(USERS_PAGE);
    }
}
