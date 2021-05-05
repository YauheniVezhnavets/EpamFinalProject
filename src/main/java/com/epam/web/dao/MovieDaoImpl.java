package com.epam.web.dao;

import com.epam.web.entities.Movie;
import com.epam.web.mapper.MovieRowMapper;


import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public class MovieDaoImpl extends AbstractDao<Movie> implements MovieDao {

    public static final String TABLE_NAME = "movies";

    private static final String REMOVE_BY_ID = "DELETE FROM movies WHERE id = ?";
    private static final String SELECT_BY_ID = "SELECT * FROM movies WHERE id = ?";
    private static final String SELECT_ALL_MOVIES = "SELECT * FROM movies ";
    private static final String SELECT_MOVIES_BY_GENRE = "SELECT * FROM movies U JOIN genres R on U.genre_id=R.id where genre = ? ";

    private static final String ADD_MOVIE = "INSERT INTO movies (name, path_to_image, description, genre_id)" +
            " VALUES (?, ?, ?, ?)";
    public static final String UPDATE_MOVIE = "UPDATE films SET name = ?, path_to_image = ?, description = ?," +
            " genre_id = ? WHERE id = ?";

    public MovieDaoImpl(Connection connection) {
        super(connection, new MovieRowMapper(), TABLE_NAME);

    }

    @Override
    public Optional<Movie> getById(Long id) throws DaoException {
        return executeForSingleResult(SELECT_BY_ID, id);
    }

    @Override
    public List<Movie> getAll() throws DaoException {
        return executeQuery(SELECT_ALL_MOVIES);
    }

    @Override
    public List<Movie> getMoviesByGenre(String genre) throws DaoException {
        return executeQuery(SELECT_MOVIES_BY_GENRE,genre);
    }

    @Override
    public void save(String movieName,String pathToImage,String description,Long genreId) throws DaoException {
        executeUpdate(ADD_MOVIE, movieName,pathToImage,description,genreId);
    }

    @Override
    public void remove(Long id) throws DaoException {
        executeUpdate(REMOVE_BY_ID, id);
    }

    @Override
    public List<Movie> getMoviesForPage(int pageNumber) throws DaoException {
        return null;
    }

    @Override
    public void updateMovie(Movie updatedFilm) throws DaoException {
        executeUpdate(UPDATE_MOVIE, updatedFilm.getName(), updatedFilm.getPathToImage(), updatedFilm.getDescription(),
                updatedFilm.getGenreId(), updatedFilm.getId());
    }

}
