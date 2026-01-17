package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.Statement;

public class SchemaInitializer {

    public static void init() {
        try (Connection con = DatabaseConnection.getConnection()) {

            StringBuilder sb = new StringBuilder();
            try (BufferedReader br = new BufferedReader(new FileReader("resources/schema.sql"))) {
                String line;
                while ((line = br.readLine()) != null) {
                    sb.append(line).append("\n");
                }
            }

            String[] commands = sb.toString().split(";");
            for (String cmd : commands) {
                String sql = cmd.trim();
                if (!sql.isEmpty()) {
                    try (Statement st = con.createStatement()) {
                        st.execute(sql);
                    }
                }
            }

            System.out.println("schema.sql executed successfully");
        } catch (Exception e) {
            System.out.println("Schema init failed:");
            e.printStackTrace();
        }
    }
}
