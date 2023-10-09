package org.example;

public class DatabasePopulateService {
    public static void main(String[] args) {
        try {

            SQLFileReader sqlFileReader = new SQLFileReader();

            String file = "populate_db.sql";

            String filling = sqlFileReader.readSQLFile(file);

            Database instance = Database.getInstance();
            int resultCreate = instance.executeUpdate(filling);

            System.out.println("res 1 =" + resultCreate);

            instance.executeClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
