package org.example;

public class DatabaseInitService {
    public static void main(String[] args) {
        try {

            SQLFileReader sqlFileReader = new SQLFileReader();

            String file = "init_db.sql";

            String createTable = sqlFileReader.readSQLFile(file);

            Database instance = Database.getInstance();
            int resultCreate = instance.executeUpdate(createTable);

            System.out.println("res 1 =" + resultCreate);

            instance.executeClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
