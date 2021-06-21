package com.epam.web.dao;

import com.epam.web.entities.Movie;
import com.epam.web.entities.User;

import java.util.List;

/**
 * MovieDao provides functionality for interaction with storage,
 * which contains data about {@link Movie} entities
 *
 * @see Dao
 * @author Yauheni Vezhnavets
 */

public interface MovieDao extends Dao<Movie> {


    void save (String movieName,String pathToImage,String description,Long genreId) throws DaoException;

    List<Movie> getMoviesForPage(int pageNumber) throws DaoException;

    void updateMovie(Movie updatedFilm) throws DaoException;

    List<Movie> getMoviesByGenre(String genre) throws DaoException;

    int getPagesCount() throws DaoException;

    int getCountOfMovies () throws DaoException;

}
