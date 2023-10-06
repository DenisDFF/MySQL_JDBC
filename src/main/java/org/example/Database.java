package org.example;

import java.sql.*;

public class Database {

    private static final Database INSTANCE = new Database();

    private static Connection connector;

    public static Connection getConnector() {
        return connector;
    }

    private Database() {
        H2Data();
    }

    public static Database getInstance() {
        return INSTANCE;
    }

    private void H2Data() {
        String dbUrl = "jdbc:h2:~/test";
        String sqlFilePath = ("init_db.sql");

        try {
            connector = DriverManager.getConnection(dbUrl, "sa", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int executeUpdate (String query) {
        try {
            Statement statement = connector.createStatement();
            return statement.executeUpdate(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ResultSet executeResult (String query) {
        try {
            Statement statement = connector.createStatement();
            return statement.executeQuery(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void executeClose () {
        try {
            connector.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
