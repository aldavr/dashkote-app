package com.example.framework.tests;

import org.testng.annotations.Test;
import java.sql.*;

public class DbTest {

    /*
    Prerequisites

    - Spin up SQL container on Docker.
            docker run -e "ACCEPT_EULA=Y" -e "SA_PASSWORD=<YourStrong@Passw0rd>" \
                    -p 1433:1433 --name sql1 --hostname sql1 \
                    -d mcr.microsoft.com/mssql/server:2019-latest
    - Add Dependencies into POM.
            <!-- https://mvnrepository.com/artifact/com.microsoft.sqlserver/mssql-jdbc -->
            <dependency>
                <groupId>com.microsoft.sqlserver</groupId>
                <artifactId>mssql-jdbc</artifactId>
                <version>10.2.1.jre17</version>
            </dependency>
    */

    String query = "SELECT *  FROM [TestDB].[dbo].[piiData];";
    String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=TestDB;encrypt=true;trustServerCertificate=true;user=sa;password=<YourStrong@Passw0rd>";


    @Test
    public void readingFromDatabaseTest() throws SQLException {

        // Load SQL Server JDBC driver and establish connection.
        try (Connection connection = DriverManager.getConnection(connectionUrl)) {

            System.out.println("Connected to SQL Server");

            // Create Statement Object
            Statement statement = connection.createStatement();

            // Execute the SQL Query. Store results in ResultSet.
            ResultSet rs = statement.executeQuery(query);

            // While Loop to iterate through all data and print results.
            while (rs.next()) {
                String firstName = rs.getString(2);
                String lastName = rs.getString(3);
                String ssn = rs.getString(4);
                System.out.println(firstName + "  " + lastName + "  " + ssn);
            }

            // Closing connection.
            rs.close();

        } catch (Exception e) {
            System.out.println();
            e.printStackTrace();
        }

    }
}
