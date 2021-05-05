package com.epam.web.service;

import com.epam.web.dao.*;
import com.epam.web.entities.Movie;

import java.util.List;
import java.util.Optional;


public class MovieService {

    private final DaoHelperFactory daoHelperFactory;


    public MovieService(DaoHelperFactory daoHelperFactory) {
        this.daoHelperFactory = daoHelperFactory;
    }

    public List<Movie> getAllMovies() throws ServiceException {

        try (DaoHelper daoHelper = daoHelperFactory.create()) {
            MovieDao movieDao = daoHelper.createMovieDao();
            return movieDao.getAll();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public List<Movie> getAllMoviesByGenre(String genre) throws ServiceException {

        try (DaoHelper daoHelper = daoHelperFactory.create()) {
            MovieDao movieDao = daoHelper.createMovieDao();
            return movieDao.getMoviesByGenre(genre);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public Optional <Movie> getMovie (Long movieID) throws ServiceException {

        try (DaoHelper daoHelper = daoHelperFactory.create()) {
            MovieDao movieDao = daoHelper.createMovieDao();
            return movieDao.getById(movieID);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public void removeMovieById (Long movieID) throws ServiceException {

        try (DaoHelper daoHelper = daoHelperFactory.create()) {
            MovieDao movieDao = daoHelper.createMovieDao();
            daoHelper.startTransaction();
            movieDao.remove(movieID);
            daoHelper.endTransaction();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
    public void saveMovie(String movieName,String pathToImage,String description,Long genreId) throws ServiceException {
        try (DaoHelper daoHelper = daoHelperFactory.create()) {
            MovieDao musicDao = daoHelper.createMovieDao();

            musicDao.save(movieName,pathToImage,description,genreId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

}
