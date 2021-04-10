package com.epam.web.dao;

import com.epam.web.connection.ProxyConnection;


public class DaoHelper implements AutoCloseable {

    private ProxyConnection connection;

    public DaoHelper(ProxyConnection connection) {
        this.connection = connection;
    }


    public UserDao createUserDao() {
        return new UserDaoImpl(connection);
    }

    @Override
    public void close()  {
        connection.close();
    }

}