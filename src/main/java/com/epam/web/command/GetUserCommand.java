package com.epam.web.command;

import com.epam.web.dao.DaoException;
import com.epam.web.entities.User;
import com.epam.web.service.ServiceException;
import com.epam.web.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Optional;

public class GetUserCommand implements Command {

    public static final String USER = "user";
    private static final String RATING_PAGE = "/WEB-INF/view/rating.jsp";
    private  final UserService userService;


    public GetUserCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException, DaoException {

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(USER);
        long id  = user.getId();
        Optional<User> optionalUser = userService.getUserById(id);

        session.setAttribute(USER, user);

        return CommandResult.forward(RATING_PAGE);

    }
}
