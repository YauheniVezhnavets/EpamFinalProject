package com.epam.web.dao;

import com.epam.web.entities.Genre;

import java.util.List;
import java.util.Optional;

/**
 * GenreDao is marker-interface, for interaction with storage,
 * contains data about {@link Genre} entities
 *
 * @see Dao
 * @author Yauheni Vezhnavets
 */

public interface GenreDao extends Dao <Genre> {
    /**
     * returns all genres for specified movie
     * @param movieId id of the specified movie
     * @return list of all genres, related to specified movie
     * @throws DaoException if request to the storage is invalid
     */

    Optional<Genre> getGenreById(Long movieId) throws DaoException;

    /**
     * returns all genres
     * @return list of all genres
     * @throws DaoException if request to the storage is invalid
     */

    List <Genre> getAllGenres() throws DaoException;

}
