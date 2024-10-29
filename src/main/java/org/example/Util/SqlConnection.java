package org.example.util;
import java.sql.*;
public class SqlConnection
{
    private static final String URL = "jdbc:sqlserver://localhost;instanceName=dogpension;portNumber=1433;databaseName=dogpension";
    private static final String USER = "";
    private static final String PASS = "";

    public static Connection getConnection() throws Exception
    {
        Connection con = null;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        con = DriverManager.getConnection(URL, USER, PASS);
        return con;
    }
}
