package com.epam.web.service;

import com.epam.web.dao.DaoHelper;
import com.epam.web.dao.DaoHelperFactory;
import com.epam.web.dao.GenreDao;
import com.epam.web.dao.UserDao;
import com.epam.web.entities.Genre;
import com.epam.web.entities.User;

import java.util.List;
import java.util.Optional;

public class GenreService {

    private DaoHelperFactory daoHelperFactory;


    public GenreService(DaoHelperFactory daoHelperFactory) {
        this.daoHelperFactory = daoHelperFactory;
    }


    public List <Genre> getAllGenres() throws ServiceException {

        try (DaoHelper helper = daoHelperFactory.create()) {
            GenreDao genreDao = helper.createGenreDao();
            List <Genre> genres = genreDao.getAll();

            return genres;
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }

    public Optional <Genre> getGenreById(Long id) throws ServiceException {

        try (DaoHelper helper = daoHelperFactory.create()) {
            GenreDao genreDao = helper.createGenreDao();
            Optional <Genre> genre = genreDao.getById(id);

            return genre;
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }




}
