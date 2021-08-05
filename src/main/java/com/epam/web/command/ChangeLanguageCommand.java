package com.epam.web.command;

import com.epam.web.dao.DaoException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ChangeLanguageCommand implements Command {

    private static final String BELARUS = "belarus";
    private static final String RUSSIAN = "russian";
    private static final String ENGLISH_LOCAL = "EN";
    private static final String BELARUS_LOCAL = "BY";
    private static final String RUSSIAN_LOCAL = "RU";

    private static final String LANGUAGE = "language";
    private static final String LOCAL = "local";
    private static final String CURRENT_PAGE = "currentPage";

    private final static String INDEX = "/index.jsp";


    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws DaoException {
        String language = request.getParameter(LANGUAGE);
        HttpSession session = request.getSession();
        String page = (String) session.getAttribute(CURRENT_PAGE);

        switch (language) {
            case BELARUS:
                session.setAttribute(LOCAL, BELARUS_LOCAL);
                break;
            case RUSSIAN:
                session.setAttribute(LOCAL, RUSSIAN_LOCAL);
                break;
            default:
                session.setAttribute(LOCAL, ENGLISH_LOCAL);
        }

        return page != null ? CommandResult.forward(page) : CommandResult.forward(INDEX);
    }
}
