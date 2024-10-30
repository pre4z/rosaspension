package org.example.Util;

import org.example.User;
import org.example.UserDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao
{

    @Override
    public List<User> getAllUsers() throws Exception
    {
        Connection con = null;
        List<User> eventTags = new ArrayList<User>();
        try
        {
            String sql = "SELECT * FROM tblUsers";
            con = SqlConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next())
            {
                User user = new User(rs.getInt(1), rs.getString(2));
                User.add(User);
            }
            return null;
        }
        catch(Exception e)
        {
            System.out.println("EventTag getAllEventTags failed");
        }
        return eventTags;
    }

    @Override
    public void createUser(String tagName) throws Exception
    {
        Connection con = null;
        try
        {
            String sql = "insert into tblUser (Users) values (?)";
            con = SqlConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, tagName);
            int affectedRows = ps.executeUpdate();
            if (affectedRows > 0)
            {
                System.out.println("EventTag created successfully");
            }
            else
            {
                System.out.println("EventTag created failed");
            }
        }
        catch(Exception e)
        {
            System.out.println("EventTag created failed with exception");
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
            ps.setString(8,user.getCPRNumber());
            ps.setBoolean(9,user.getIsEmployee());
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
    public void deleteUsers(int UserID) throws Exception
    {
        Connection con = null;
        try
        {
            String sql = "delete from tblUsers where UsersID = ?";
            con = SqlConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, UserID);
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
    public void readUser(String no) throws Exception {

    }

    @Override
    public void readAllUsers() throws Exception {

    }

    @Override
    public void createUser(User user) throws Exception {

    }
}
