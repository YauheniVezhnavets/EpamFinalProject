package com.epam.web;

import com.epam.web.command.Command;
import com.epam.web.command.CommandFactory;
import com.epam.web.command.CommandResult;
import com.epam.web.service.ServiceException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Controller extends HttpServlet {

    private final static String COMMAND = "command";
    private final static String ERROR_PAGE = "/error.jsp";
    private final static String COMMAND_HEADER = "/controller?command=";


    CommandFactory commandFactory = new CommandFactory();


    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        process(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        process(request, response);
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String commandType = request.getParameter(COMMAND);
        Command command = commandFactory.create(commandType);
        String page;
        boolean isRedirect = false;
        try {
            CommandResult commandResult = command.execute(request,response);
            page = commandResult.getPage();
            isRedirect = commandResult.isRedirected();
        } catch (Exception | ServiceException e){
            request.setAttribute("errorMessage",e.getMessage());
            page= ERROR_PAGE;
        }

        if (!isRedirect){
            forward (request,response,page);
        }
        else {
            redirect(response,page);
        }
    }

    private void forward(HttpServletRequest request, HttpServletResponse response, String page) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(page);
        requestDispatcher.forward(request,response);
    }

    private void redirect(HttpServletResponse response, String page) throws IOException {
        String contextPath = getServletContext().getContextPath();
        String pagePath = contextPath + COMMAND_HEADER + page;
        response.sendRedirect(pagePath);
    }
}
