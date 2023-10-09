package org.example;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class DatabaseQueryService {
    public static void main(String[] args) {
        try {

            SQLFileReader sqlFileReader = new SQLFileReader();

            String file = "find_max_salary_worker.sql";
            String file2 = "find_max_projects_client.sql";
            String file3 = "find_longest_project.sql";
            String file4 = "find_youngest_eldest_workers.sql";
            String file5 = "print_project_prices.sql";

            String query = sqlFileReader.readSQLFile(file);
            String query2 = sqlFileReader.readSQLFile(file2);
            String query3 = sqlFileReader.readSQLFile(file3);
            String query4 = sqlFileReader.readSQLFile(file4);
            String query5 = sqlFileReader.readSQLFile(file5);

            Database instance = Database.getInstance();
            ResultSet resultSet = instance.executeResult(query);
            ResultSet resultSet2 = instance.executeResult(query2);
            ResultSet resultSet3 = instance.executeResult(query3);
            ResultSet resultSet4 = instance.executeResult(query4);
            ResultSet resultSet5 = instance.executeResult(query5);

            String resultString = resultSetToString(resultSet);
            String resultString2 = resultSetToString(resultSet2);
            String resultString3 = resultSetToString(resultSet3);
            String resultString4 = resultSetToString(resultSet4);
            String resultString5 = resultSetToString(resultSet5);

            System.out.println(resultString);
            System.out.println(resultString2);
            System.out.println(resultString3);
            System.out.println(resultString4);
            System.out.println(resultString5);

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
