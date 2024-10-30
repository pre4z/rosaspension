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
                User user = new User();
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
