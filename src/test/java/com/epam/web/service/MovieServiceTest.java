package com.epam.web.service;

import com.epam.web.dao.*;
import com.epam.web.dto.MovieDto;
import com.epam.web.entities.Movie;
import com.epam.web.entities.Review;
import org.mockito.Mockito;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.when;

public class MovieServiceTest {

    private static final long VALID_ID = 1;
    private static final Long VALID_GENRE_ID = 1L;
    private static final String VALID_NAME = "movie";
    private static final Double VALID_RATING = 0.0;
    private static final String VALID_PATH_TO_MOVIE = "path_to_movie";
    private static final String VALID_DESCRIPTION = "description";
    private static final List<Review> VALID_REVIEWS = Collections.emptyList();
    private static final long INVALID_ID = -1L;
    private static final Movie VALID_MOVIE = new Movie(VALID_ID, VALID_NAME, VALID_PATH_TO_MOVIE, VALID_DESCRIPTION, VALID_GENRE_ID);
    private static final MovieDto VALID_MOVIE_DTO = new MovieDto(VALID_MOVIE, VALID_RATING, VALID_REVIEWS);


    private MovieService service;

    private DaoHelperFactory factory = Mockito.mock(DaoHelperFactory.class);
    private DaoHelper daoHelper = Mockito.mock(DaoHelper.class);


    @Before
    public void setUp() throws DaoException {
        when(factory.create()).thenReturn(daoHelper);
        GenreDao genreDaoMock = Mockito.mock(GenreDao.class);
        when(genreDaoMock.getAll()).thenReturn(Collections.emptyList());
        when(daoHelper.createGenreDao()).thenReturn(genreDaoMock);

        MovieDao movieDaoMock = Mockito.mock(MovieDao.class);
        MovieRatingDao ratingDaoMock = Mockito.mock(MovieRatingDao.class);
        ReviewDao reviewDaoMock = Mockito.mock(ReviewDao.class);


        when(ratingDaoMock.hasRating(anyLong(), anyLong())).thenReturn(true);
        when(movieDaoMock.getById(VALID_GENRE_ID)).thenReturn(Optional.of(VALID_MOVIE));
        when(movieDaoMock.getById(INVALID_ID)).thenReturn((Optional.empty()));
        when(ratingDaoMock.getMovieRating(anyLong())).thenReturn(VALID_RATING);
        when(reviewDaoMock.getAllReviewsByMovieId(anyLong())).thenReturn(Collections.emptyList());

        when(daoHelper.createMovieDao()).thenReturn(movieDaoMock);
        when(daoHelper.createGenreDao()).thenReturn(genreDaoMock);
        when(daoHelper.createMovieRatingDao()).thenReturn(ratingDaoMock);
        when(daoHelper.createReviewDao()).thenReturn(reviewDaoMock);

        service = new MovieService(factory);
    }

    @Test
    public void testGetMovieByIdShouldReturnMovieWhenMovieExist() throws ServiceException {
        Optional<MovieDto> movieById = service.getMovieDtoById(VALID_ID);
        Assert.assertEquals(VALID_MOVIE_DTO, movieById.get());
    }

    @Test
    public void testGetMovieByIdShouldReturnEmptyWhenMovieNotExist() throws ServiceException {
        Optional<MovieDto> movieById = service.getMovieDtoById(INVALID_ID);
        Assert.assertEquals(movieById, Optional.empty());
    }
}
