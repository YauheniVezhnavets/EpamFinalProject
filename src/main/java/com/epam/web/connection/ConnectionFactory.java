package com.epam.web.connection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {

    private final static String PROPERTY_FILE = "db.properties";
    private final static String DRIVER = "db.driver";
    private final static String URL = "db.url";
    private final static String LOGIN = "db.login";
    private final static String PASSWORD = "db.password";

    private String url;
    private String login;
    private String password;

    public ConnectionFactory() {
        initializeProperties();
    }


    public Connection create() throws SQLException {

        return DriverManager.getConnection(url, login, password);
    }

    private void initializeProperties() {

        try {
            Properties properties = new ResourcesLoader().loadProperties(PROPERTY_FILE);

            String driver = properties.getProperty(DRIVER);
            Class.forName(driver);

            url = properties.getProperty(URL);
            login = properties.getProperty(LOGIN);
            password = properties.getProperty(PASSWORD);

        } catch (ClassNotFoundException | IOException e) {
            throw new ConnectionException(e);
        }
    }

}
