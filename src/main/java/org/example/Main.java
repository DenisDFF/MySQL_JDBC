package org.example;

import java.sql.*;


public class Main {

    public static void main(String[] args) throws Exception {
        try {

            SQLFileReader sqlFileReader = new SQLFileReader();

            String file = "find_max_salary_worker.sql";

            String query = sqlFileReader.readSQLFile(file);
//            System.out.println(query);

            Database instance = Database.getInstance();
            ResultSet resultSet = instance.executeResult(query);

            String resultString = resultSetToString(resultSet);

            System.out.println(resultString);

            instance.executeClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
}

    public static String resultSetToString(ResultSet resultSet) throws SQLException {
        StringBuilder result = new StringBuilder();
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();

        while (resultSet.next()) {
            for (int i = 1; i <= columnCount; i++) {
                result.append(resultSet.getString(i)).append(", ");
            }
            result.append("\n");
        }

        return result.toString();
    }
}