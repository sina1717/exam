package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
    public static Connection connection;

    static {
        try {
            connection = DriverManager.
                    getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","1717");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
