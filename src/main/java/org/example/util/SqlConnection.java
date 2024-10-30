package org.example.util;
import java.sql.*;
public class SqlConnection
{
    private static final String URL = "jdbc:sqlserver://162.19.246.106:1433;databaseName=dbDogPension;";
    private static final String USER = "sa";
    private static final String PASS = "securepassword123!";

    public static Connection getConnection() throws Exception
    {
        Connection con = null;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        con = DriverManager.getConnection(URL, USER, PASS);
        return con;
    }
}
