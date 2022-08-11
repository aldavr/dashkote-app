package com.example.framework.utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbManager {
    private static Connection connection = null;

    // SQL Server
    public static Connection setDbConnection(String connectionString, String dbUserName, String dbPassword) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(connectionString, dbUserName, dbPassword);
            if (!connection.isClosed()) System.out.println("Successfully connected to SQL server");
            return connection;
        } catch (SQLException | ClassNotFoundException throwable) {
            System.out.println("Exception generated. See Execution log for more details.");
        }
        return null;
    }

    public static List<String> getQuery(String query) throws SQLException {
        Statement St = connection.createStatement();
        try (St; ResultSet rs = St.executeQuery(query)) {
            List<String> values = new ArrayList<String>();
            while (rs.next()) {
                values.add(rs.getString(1));
            }
            System.out.println(values);
            return values;
        }
    }
}
