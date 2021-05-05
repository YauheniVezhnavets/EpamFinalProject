package com.epam.web.dao;

import com.epam.web.entities.Genre;
import com.epam.web.mapper.GenreRowMapper;


import java.sql.Connection;
import java.util.List;
import java.util.Optional;


public class GenreDaoImpl extends AbstractDao<Genre> implements GenreDao {

    public static final String TABLE_NAME = "genres";
    private static final String SELECT_ALL_GENRES = "SELECT * FROM genres";
    private static final String SELECT_GENRE_BY_ID = "SELECT * FROM genres where id =? ";


    public GenreDaoImpl(Connection connection) {
        super(connection, new GenreRowMapper(), TABLE_NAME);
    }


    @Override
    public Optional<Genre> getGenreById(Long id) throws DaoException {
        return executeForSingleResult(SELECT_GENRE_BY_ID,id);
    }

    @Override
    public List<Genre> getAllGenres() throws DaoException {
        return executeQuery(SELECT_ALL_GENRES);
    }
}
