package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class SQLFileReader {

    public static String readSQLFile(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        BufferedReader reader = new BufferedReader(new FileReader(path.toFile()));
        String sql = reader.lines().collect(Collectors.joining("\n"));
        reader.close();
        return sql;
    }
}