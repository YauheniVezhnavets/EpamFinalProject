package com.epam.web.dao;

import com.epam.web.entities.User;



import java.util.Optional;

public interface UserDao extends Dao<User>{

    Optional<User> findUserByLoginAndPassword(String username, String password) throws DaoException;

}
