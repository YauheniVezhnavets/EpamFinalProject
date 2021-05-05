package com.epam.web.command;

import com.epam.web.dao.DaoException;
import com.epam.web.service.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {


    CommandResult execute (HttpServletRequest request, HttpServletResponse response) throws DaoException, ServiceException;

}
