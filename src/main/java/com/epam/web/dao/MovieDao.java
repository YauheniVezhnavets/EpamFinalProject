package com.epam.web.dao;

import com.epam.web.entities.Movie;
import com.epam.web.entities.User;

import java.util.List;
import java.util.Optional;

/**
 * MovieDao provides functionality for interaction with storage,
 * which contains data about {@link Movie} entities
 *
 * @see Dao
 * @author Yauheni Vezhnavets
 */

public interface MovieDao extends Dao<Movie> {

    /**
     * Save an instance of movie into the storage
     * @param movieName instance of nameMovie, needed to be saved
     * @param pathToImage instance of path to image of Movie, needed to be saved
     * @param description instance of description, needed to be saved
     * @param genreId instance of genre id, needed to be saved
     * @throws DaoException is request to storage is corrupted or record for
     * specified item is already in the storage
     */
    void save (String movieName,String pathToImage,String description,Long genreId) throws DaoException;

    /**
     * Loads movies for specified page number
     * @param pageNumber number of page, on which received movies will be displayed
     * @return List instances of movies in range N * (pageNumber - 1) .. N * pageNumber,
     * where N - is amount of movies per one page. Concrete value of fmovies per page may depends on
     * implementation
     * @throws DaoException is request to storage is corrupted
     */

    List<Movie> getMoviesForPage(int pageNumber) throws DaoException;

    /**
     * Update record for specified movie.
     * If there is not record for specified movie, nothing happens
     * @param updatedFilm instance of movie, needed to be updated
     * @throws DaoException if request to storage is corrupted
     */

    void updateMovie(Movie updatedFilm) throws DaoException;

    /**
     * Searches movies for specified genre
     * @param genre id of needed movie genre
     * @return List of movies which genre id is equal to specified genre
     * @throws DaoException if request to storage is corrupted
     */

    List<Movie> getMoviesByGenre(String genre) throws DaoException;

    /**
     *  Defines the movies pages count
     * @return count pages with movies, where page is range of movies, described
     * @throws DaoException is request to storage is corrupted
     */

    int getPagesCount() throws DaoException;


    /**
     *  Defines all movies
     * @return count of all movies
     * @throws DaoException is request to storage is corrupted
     */

    int getCountOfMovies () throws DaoException;

}
