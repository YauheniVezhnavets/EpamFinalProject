package com.epam.web.dao;


import com.epam.web.entities.Identifiable;

import java.util.List;
import java.util.Optional;

public interface Dao <T extends Identifiable> {

    Optional<T> getById (Long id);

    List <T> getAll() throws DaoException;

    void save (T item);

    void remove (Long id);

}
