package com.epam.web.command;

import com.epam.web.dao.DaoException;
import com.epam.web.entities.User;
import com.epam.web.entities.UserRating;
import com.epam.web.service.ServiceException;
import com.epam.web.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Optional;

public class LoginCommand implements Command {

    private final UserService userService;
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";

    public LoginCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {

        String username = request.getParameter(USERNAME);
        String password = request.getParameter(PASSWORD);

        Optional<User> optionalUser = userService.login(username, password);

        HttpSession session = request.getSession();

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            if (user.getUserRating() == UserRating.BANNED) {
                request.setAttribute("bannedMessage", true);
                return CommandResult.forward("/index.jsp");
            }
            session.setAttribute("user", user);
            return CommandResult.redirect("mainPage");
        } else {
            request.setAttribute("errorMessage", true);
            return CommandResult.forward("/index.jsp");
        }
    }
}
