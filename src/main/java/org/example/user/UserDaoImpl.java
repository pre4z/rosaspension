package org.example.user;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.example.util.SqlConnection;

public class UserDaoImpl implements UserDao
{

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
                User user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getBoolean(9),rs.getBoolean(10));
                users.add(user);
            }
            return null;
        }
        catch(Exception e)
        {
            System.out.println("EventTag getAllEventTags failed");
        }
        return users;
    }

    @Override
    public void createUser(User user) throws Exception
    {
        Connection con = null;
        try
        {
            String sql = "insert into tblUser (Users) values (?),?, +?, ?,";
            con = SqlConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
            ps.setString(3,user.getLastName());
            ps.setString(4,user.getUserName());
            ps.setString(5,user.getAdress());
            ps.setString(6,user.getPostalCode());
            ps.setString(7,user.getPhoneNo());
            ps.setString(8,user.getCprNumber());
            ps.setBoolean(9,user.getEmployee());
            ps.setInt(10, user.getUserID());
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

    @Override
    public void updateUser(User user) throws Exception
    {
        Connection con = null;
        try
        {
            String sql = "update tblUsers set fldFirstName = ?, set fldLastName = ? where UserID = ?";
            con = SqlConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
            ps.setString(3,user.getLastName());
            ps.setString(4,user.getUserName());
            ps.setString(5,user.getAdress());
            ps.setString(6,user.getPostalCode());
            ps.setString(7,user.getPhoneNo());
            ps.setString(8,user.getCprNumber());
            ps.setBoolean(9,user.getEmployee());
            ps.setInt(10, user.getUserID());


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

    @Override
    public void deleteUsers(int userID) throws Exception
    {
        Connection con = null;
        try
        {
            String sql = "delete from tblUsers where UsersID = ?";
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

    @Override
    public User getUserByID(int user) throws Exception {
        return null;
    }
}
