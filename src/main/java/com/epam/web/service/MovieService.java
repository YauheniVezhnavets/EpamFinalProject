package com.epam.web.service;

import com.epam.web.dao.*;
import com.epam.web.dto.MovieDto;
import com.epam.web.entities.Movie;
import com.epam.web.entities.MovieRating;
import com.epam.web.entities.Review;

import java.util.ArrayList;
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

    public List<MovieDto> getMoviesForPage(int page) throws ServiceException {

        try (DaoHelper daoHelper = daoHelperFactory.create()) {
            MovieDao movieDao = daoHelper.createMovieDao();
            List<Movie> moviesOnPage = movieDao.getMoviesForPage(page);
            return getMoviesDto(moviesOnPage);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public int getPagesCount() throws ServiceException {
        try (DaoHelper daoHelper = daoHelperFactory.create()) {
            MovieDao movieDao = daoHelper.createMovieDao();
            return movieDao.getPagesCount();
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    public List<Integer> getPaginationList() throws ServiceException {
        int totalRowsAmount = getPagesCount();
        List<Integer> paginationList = new ArrayList<>();
        for (int i = 1; i <= totalRowsAmount; i++) {
            paginationList.add(i);
        }
        return paginationList;
    }

    public List<MovieDto> getAllMoviesByGenre(String genre) throws ServiceException {

        try (DaoHelper daoHelper = daoHelperFactory.create()) {
            MovieDao movieDao = daoHelper.createMovieDao();
            List<Movie> moviesByGenre = movieDao.getMoviesByGenre(genre);
            return getMoviesDto(moviesByGenre);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    public Optional<MovieDto> getMovieDtoById(long movieId) throws ServiceException {

        try (DaoHelper daoHelper = daoHelperFactory.create()) {
            MovieDao movieDao = daoHelper.createMovieDao();
            Optional<Movie> optionalMovie = movieDao.getById(movieId);
            if (optionalMovie.isPresent()) {
                Movie movie = optionalMovie.get();
                MovieDto movieDto = getMovieDto(movie);
                return Optional.of(movieDto);
            }
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
        return Optional.empty();
    }


    private List<MovieDto> getMoviesDto(List<Movie> movies) throws ServiceException {
        List<MovieDto> listOfMoviesDto = new ArrayList<>();
        for (Movie movie : movies) {
            MovieDto movieDto = getMovieDto(movie);
            listOfMoviesDto.add(movieDto);
        }
        return listOfMoviesDto;
    }

    private MovieDto getMovieDto(Movie movie) throws ServiceException {
        try (DaoHelper daoHelper = daoHelperFactory.create()) {
            ReviewDao reviewDao = daoHelper.createReviewDao();
            MovieRatingDao movieRatingDao = daoHelper.createMovieRatingDao();
            long movieId = movie.getId();
            List<Review> listOfReview;
            double movieRating;
            List<MovieRating> movieRatings;
            try {
                listOfReview = reviewDao.getAllReviewsByMovieId(movieId);
                movieRatings = movieRatingDao.movieHasRating(movieId);
                if (!movieRatings.isEmpty()) {
                    movieRating = movieRatingDao.getMovieRating(movieId);
                } else {
                    movieRating = 0.0;
                }
            } catch (DaoException e) {
                throw new ServiceException(e.getMessage(), e);
            }
            return new MovieDto(movie, movieRating, listOfReview);
        }
    }

    public void removeMovieById(Long movieID) throws ServiceException {

        try (DaoHelper daoHelper = daoHelperFactory.create()) {
            MovieDao movieDao = daoHelper.createMovieDao();
            daoHelper.startTransaction();
            movieDao.remove(movieID);
            daoHelper.endTransaction();
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    public void saveMovie(String movieName, String pathToImage, String description, Long genreId) throws ServiceException {
        try (DaoHelper daoHelper = daoHelperFactory.create()) {
            MovieDao movieDao = daoHelper.createMovieDao();
            movieDao.save(movieName, pathToImage, description, genreId);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }
}


