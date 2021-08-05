package com.epam.web.service;

import com.epam.web.dao.DaoException;
import com.epam.web.dao.DaoHelper;
import com.epam.web.dao.DaoHelperFactory;
import com.epam.web.dao.GenreDao;
import com.epam.web.entities.Genre;
import org.mockito.Mockito;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.when;


public class GenreServiceTest {
    private GenreService genreService;

    private DaoHelperFactory factory = Mockito.mock(DaoHelperFactory.class);
    private DaoHelper daoHelper = Mockito.mock(DaoHelper.class);

    @Before
    public void setUp() throws DaoException {
        when(factory.create()).thenReturn(daoHelper);
        GenreDao genreDaoMock = Mockito.mock(GenreDao.class);
        when(genreDaoMock.getAll()).thenReturn(Collections.emptyList());
        when(daoHelper.createGenreDao()).thenReturn(genreDaoMock);
        this.genreService = new GenreService(factory);
    }

    @Test
    public void testGetAllGenresShouldReturnAllGenres() throws ServiceException {
        List<Genre> allGenres = genreService.getAllGenres();
        Assert.assertEquals(allGenres, Collections.emptyList());
    }
}
