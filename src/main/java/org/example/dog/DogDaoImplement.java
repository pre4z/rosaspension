/**package org.example.dog;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DepartmentDaoImpl implements DogDao {

    private static final String URL = "jdbc:sqlserver://localhost;instanceName=YOURPC;portNumber=1433;databaseName=YOURDB";
    private static final String USERNAME = "sa"; // replace with your username
    private static final String PASSWORD = "123456"; // replace with your password

    public static Connection getConnection() throws Exception {
        Connection conn = null;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        System.out.println("Connected to the database.");
        return conn;
    }

    @Override
    public void createDog(Dog dog) throws Exception {
        // fldDogID, fldDogName, fldAge, fldRace, fldSpecialNeeds, fldPreferredVet, fldWeight, fldExpectedStay
        String sql = "INSERT INTO tblDog VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, dog.getDogID());
        pstmt.setString(2, dog.getName());
        pstmt.setInt(3, dog.getAge());
        int affectedRows = pstmt.executeUpdate();
        if (affectedRows > 0) {
            System.out.println("Department added successfully.");
        } else {
            System.out.println("Failed to add the department.");
        }
    }

    @Override
    public void readDepartment(String no) throws Exception{
        String sql = "SELECT * FROM Department WHERE dept_no = ?";
        Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, no);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            Department department = new Department();
            department.setNo(rs.getString(1));
            department.setName(rs.getString(2));
            department.setLocation(rs.getString(3));
            System.out.println(department.getNo() + " "+ department.getName()+ " "+ department.getLocation());
        } else {
            System.out.println("No department found with ID: " + no);
        }
    }

    @Override
    public void readAllDepartments() throws Exception{
        String sql = "SELECT * FROM Department";
        Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        boolean hasDepartments = false;
        while (rs.next()) {
            hasDepartments = true;
            Department department = new Department();
            department.setNo(rs.getString(1));
            department.setName(rs.getString(2));
            department.setLocation(rs.getString(3));
            System.out.println(department.getNo()+" "+ department.getName()+department.getLocation());
        }
        if (!hasDepartments) {
            System.out.println("No departments found.");
        }
    }
}

**/
