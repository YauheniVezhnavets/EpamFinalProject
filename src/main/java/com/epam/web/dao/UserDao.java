package com.epam.web.dao;

import com.epam.web.entities.User;


import java.util.Optional;
/**
 * UserDao provides functionality for interaction with storage,
 * which contains data about {@link User} entities
 *
 * @see Dao
 * @author Yauheni Vezhnavets
 */

public interface UserDao extends Dao<User> {

    /**
     * Searched for user with specified login and password
     * @param username login (name) of searched user
     * @param password password of searched user
     * @return instance of user wrapped in {@link Optional} class
     * if users with record with specified login and password is present
     * in the storage, {@code Optional.empty()} if there is no record for
     * specified parameters
     * @throws DaoException if request to the storage is invalid
     */

    Optional<User> findUserByLoginAndPassword(String username, String password) throws DaoException;

    /**
     * Searched for user with specified userId
     * @param id id of the user, which matches the record in the storage
     * @throws DaoException if request to the storage is invalid
     */

    Optional<User> findUserById(Long id) throws DaoException;

    /**
     * Changes rating by admin
     * @param id id of the user, which rating will be changed
     * @throws DaoException if request to the storage is invalid
     */

    void updateUserRatingById(String userRating, Long id) throws DaoException;

}
