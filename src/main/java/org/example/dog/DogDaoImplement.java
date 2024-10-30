package org.example.dog;

import org.example.util.SqlConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DogDaoImplement implements DogDao {

    /**
     * private int dogID;
     *     private String name;
     *     private int age;
     *     private String race;
     *     private String specialNeeds;
     *     private String preferredVet;
     *     private double weight;
     *     private int expectedStay;
     *     private int feedingFreq;
     *     private int foodInGrams;
     *     fldUserId
     *     fldFoodID
     * @param dawg
     * @throws Exception
     */

    @Override
    public void createDog(Dog dawg) throws Exception {
        // fldDogID, fldDogName, fldAge, fldRace, fldSpecialNeeds, fldPreferredVet, fldWeight, fldExpectedStay
        String sql = "INSERT INTO tblDog VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        Connection conn = SqlConnection.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, dawg.getName());
        pstmt.setInt(2, dawg.getAge());
        pstmt.setString(3, dawg.getRace());
        pstmt.setString(4, dawg.getSpecialNeeds());
        pstmt.setString(5, dawg.getPreferredVet());
        pstmt.setFloat(6, dawg.getWeight());
        pstmt.setInt(7, dawg.getExpectedStay());
        pstmt.setInt(8, dawg.getFeedingFreq());
        pstmt.setInt(9, dawg.getFoodInGrams());
        pstmt.setInt(10, dawg.getUserID());
        pstmt.setInt(11, dawg.getFoodID());
        int affectedRows = pstmt.executeUpdate();
        if (affectedRows > 0) {
            System.out.println("Dog added successfully.");
        } else {
            System.out.println("Failed to add the dog.");
        }
    }

    @Override
    public void getDog(int dogID) throws Exception{
        String sql = "SELECT * FROM tblDog WHERE fldDogID = ?";
        Connection conn = SqlConnection.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, dogID);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            Dog dawg = new Dog();
            dawg.setDogID(rs.getInt(1));
            dawg.setName(rs.getString(2));
            dawg.setAge(rs.getInt(3));
            System.out.println(dawg.getDogID() + " "+ dawg.getName()+ " "+ dawg.getAge());
        } else {
            System.out.println("No dog found with ID: " + dogID);
        }
    }

    @Override
    public void getAllDogs() throws Exception{
        String sql = "SELECT * FROM tblDog";
        Connection conn = SqlConnection.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        boolean dogsRegistered = false;
        while (rs.next()) {
            dogsRegistered = true;
            Dog dawg = new Dog();
            dawg.setDogID(rs.getInt(1));
            dawg.setName(rs.getString(2));
            dawg.setAge(rs.getInt(3));
            System.out.println(dawg.getDogID()+" "+ dawg.getName()+ dawg.getAge());
        }
        if (!dogsRegistered) {
            System.out.println("No dogs found.");
        }
    }

    public void updateDog(Dog dawg) throws Exception {
        // TBA
    }
}