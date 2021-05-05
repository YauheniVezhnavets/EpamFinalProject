package com.epam.web.dao;

import com.epam.web.entities.Genre;

import java.util.List;
import java.util.Optional;

public interface GenreDao extends Dao <Genre> {

    Optional<Genre> getGenreById(Long id) throws DaoException;

    List <Genre> getAllGenres() throws DaoException;

}
