package com.epam.web.service;

import com.epam.web.dao.*;
import com.epam.web.entities.Movie;
import com.epam.web.entities.User;

import java.util.List;
import java.util.Optional;

public class UserService  {


    private DaoHelperFactory daoHelperFactory;


    public UserService(DaoHelperFactory daoHelperFactory) {

        this.daoHelperFactory = daoHelperFactory;

    }


    public Optional<User> login(String username, String password) throws ServiceException {

        try (DaoHelper helper = daoHelperFactory.create()) {
            helper.startTransaction();
            UserDao userDao = helper.createUserDao();
            Optional<User> user = userDao.findUserByLoginAndPassword(username, password);
            helper.endTransaction();
            return user;
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }

    public Optional<User> getUserById(long userId) throws ServiceException {
        try (DaoHelper helper = daoHelperFactory.create()) {
            UserDao userDao = helper.createUserDao();
            Optional<User> user = userDao.findUserById(userId);
            return user;
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    public List<User> getAllUsers() throws ServiceException {

        try (DaoHelper daoHelper = daoHelperFactory.create()) {
            UserDao userDao = daoHelper.createUserDao();
            return userDao.getAll();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public void updateUserRating(String userRating, Long id) throws ServiceException {
        try (DaoHelper daoHelper = daoHelperFactory.create()) {
            UserDao userDao = daoHelper.createUserDao();

            userDao.updateUserRatingById(userRating, id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

}
