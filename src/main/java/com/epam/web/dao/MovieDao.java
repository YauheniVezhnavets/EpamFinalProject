package com.epam.web.dao;

import com.epam.web.entities.Movie;
import com.epam.web.entities.User;

import java.util.List;


public interface MovieDao extends Dao<Movie> {
        //save (Movie item)
    void save (String movieName,String pathToImage,String description,Long genreId) throws DaoException;

    List<Movie> getMoviesForPage(int pageNumber) throws DaoException;

    void updateMovie(Movie updatedFilm) throws DaoException;

    List<Movie> getMoviesByGenre(String genre) throws DaoException;

}
