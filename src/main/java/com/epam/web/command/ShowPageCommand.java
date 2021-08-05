package com.epam.web.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ShowPageCommand implements Command {

    private String page;
    private final static String CURRENT_PAGE = "currentPage";

    public ShowPageCommand(String page) {
        this.page = page;
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession httpSession = request.getSession();
        httpSession.setAttribute(CURRENT_PAGE, page);
        return CommandResult.forward(page);
    }
}
