package com.epam.web.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public static Connection create() throws SQLException {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/movies_database", "root", "12344321");
        } catch (ClassNotFoundException e) {
            throw new ConnectionException(e);
        }
    }

}
