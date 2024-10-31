package org.example.user;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.example.util.SqlConnection;

/**
 * Preparing contact from our user object to the database.
 */
public class UserDaoImpl implements UserDao
{

    /**
     * Get a list with all the users, from the database.
     * @return
     * @throws Exception
     */
    @Override
    public List<User> getAllUsers() throws Exception
    {
        Connection con = null;
        List<User> users = new ArrayList<User>();
        try
        {
            String sql = "SELECT * FROM tblUsers";
            con = SqlConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next())
            {
                User user = new User();
                setUserProperties(rs, user);
                users.add(user);
            }
            return users;
        }
        catch(Exception e)
        {
            System.out.println("EventTag getAllEventTags failed");
        }
        return users;
    }

    /**
     * Create user in the database, using the variables given in main.
     * @param user
     * @throws Exception
     */
    @Override
    public void createUser(User user) throws Exception
    {
        Connection con = null;
        try
        {
            String sql = "insert into tblUsers values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            con = SqlConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
            ps.setString(3,user.getUserName());
            ps.setString(4,user.getAdress());
            ps.setString(5,user.getPostalCode());
            ps.setString(6,user.getPhoneNo());
            ps.setString(7,user.getCprNumber());
            ps.setBoolean(8,user.getEmployee());
            ps.setBoolean(9,user.getVerified());
            int affectedRows = ps.executeUpdate();
            if (affectedRows > 0)
            {
                System.out.println("Customer created successfully");
            }
            else
            {
                System.out.println("Customer creation failed");
            }
        }
        catch(Exception e)
        {
            System.out.println("User creation failed with exception");
        }
    }

    /**
     * Update the user information in the database, through input in main.
     * @param user
     * @throws Exception
     */
    @Override
    public void updateUser(User user) throws Exception
    {
        Connection con = null;
        try
        {
            String sql = "update tblUsers set fldFirstName = ?, fldLastName = ?, fldUserName = ?, fldAdress = ?, fldPostalCode = ?, fldPhoneNo = ?, fldCPRNumber = ?, fldIsEmployee = ? where fldUserID = ?";
            con = SqlConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
            ps.setString(3,user.getUserName());
            ps.setString(4,user.getAdress());
            ps.setString(5,user.getPostalCode());
            ps.setString(6,user.getPhoneNo());
            ps.setString(7,user.getCprNumber());
            ps.setBoolean(8,user.getEmployee());
            ps.setInt(9, user.getUserID());


            int affectedRows = ps.executeUpdate();
            if (affectedRows > 0)
            {
                System.out.println("User updated successfully");
            }
            else
            {
                System.out.println("User updated failed");
            }
        }
        catch(Exception e)
        {
            System.out.println("User updated failed with exception");
        }
    }

    /**
     * Delete user from the DB, gets input through main, works through userID.
     * @param userID
     * @throws Exception
     */
    @Override
    public void deleteUsers(int userID) throws Exception
    {
        Connection con = null;
        try
        {
            String sql = "delete from tblUsers where fldUserID = ?";
            con = SqlConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, userID);
            int affectedRows = ps.executeUpdate();
            if (affectedRows > 0)
            {
                System.out.println("User deleted successfully");
            }
            else
            {
                System.out.println("User deleted failed");
            }
        }
        catch(Exception e)
        {
            System.out.println("User deleted failed with exception");
        }
    }

    /**
     * Show a specific user from our database.
     * @param userID
     * @return
     * @throws Exception
     */
    @Override
    public User getUserByID(int userID) throws Exception
    {
        Connection con = null;
        try
        {
            String sql = "SELECT * FROM tblUsers WHERE fldUserID = ?";
            con = SqlConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, userID);
            ResultSet rs = ps.executeQuery();
            User user = new User();

            if (rs.next())
            {
                setUserProperties(rs, user);
            }

            return user;
        }
        catch(Exception e)
        {
            System.out.println("Error while trying to get user by ID");
        }
        return null;
    }

    /**
     * Method to get information of the user out of the database.
     * @param rs
     * @param user
     * @throws Exception
     */
    private void setUserProperties(ResultSet rs, User user) throws Exception
    {
        user.setUserID(rs.getInt(1));
        user.setFirstName(rs.getString(2));
        user.setLastName(rs.getString(3));
        user.setUserName(rs.getString(4));
        user.setAdress(rs.getString(5));
        user.setPostalCode(rs.getString(6));
        user.setPhoneNo(rs.getString(7));
        user.setCprNumber(rs.getString(8));
        user.setEmployee(rs.getBoolean(9));
        user.setVerified(rs.getBoolean(10));
    }
}
