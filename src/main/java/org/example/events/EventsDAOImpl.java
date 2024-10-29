package org.example.events;

import org.example.Util.SqlConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EventsDAOImpl implements EventsDAO
{
    @Override
    public List<Event> getAllEventsByDogID(int dogID) throws Exception
    {
        Connection con = null;
        List<Event> events = new ArrayList<Event>();
        try
        {
            String sql = "select * from tblevents where dogID = ?";
            con = SqlConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, dogID);
            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {
                Event event = new Event(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getInt(4), rs.getInt(5));
                events.add(event);
            }
        }
        catch (Exception e)
        {
            System.out.println("Error while trying to get events");
        }
        return events;
    }

    @Override
    public Event getEventById(int eventID) throws Exception
    {
        Connection con = null;
        try
        {
            String sql = "select * from tblevents where eventID = ?";
            con = SqlConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, eventID);
            ResultSet rs = ps.executeQuery();
            if (rs.next())
            {
                return new Event(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getInt(4), rs.getInt(5));
            }
        }
        catch (Exception e)
        {
            System.out.println("Error while trying to get event by ID");
        }
        return null;
    }

    @Override
    public void CreateEvent(Event event) throws Exception
    {
        Connection con = null;
        try
        {
            String sql = "INSERT INTO tblEvents VALUES (?, ?, ?, ?)";
            con = SqlConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, event.getEventDescription());
            ps.setDate(2, event.getEventDate());
            ps.setInt(3, event.getEventID());
            ps.setInt(4, event.getDogID());
            int affectedRows = ps.executeUpdate();
            if (affectedRows > 0)
            {
                System.out.println("Event created successfully");
            }
            else
            {
                System.out.println("Event creation failed");
            }
        }
        catch (Exception e)
        {
            System.out.println("Error while trying to create event");
        }
    }

    @Override
    public void UpdateEvent(Event event) throws Exception
    {
        Connection con = null;
        try
        {
            String sql = "UPDATE tblEvents SET fldEventDescription = ?, fldEventDate = ?, fldDogID = ?, fldEventTagID WHERE eventID = ?";
            con = SqlConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, event.getEventDescription());
            ps.setDate(2, event.getEventDate());
            ps.setInt(3, event.getDogID());
            ps.setInt(4, event.getEventTagID());
            ps.setInt(5, event.getEventID());
            int affectedRows = ps.executeUpdate();
            if (affectedRows > 0)
            {
                System.out.println("Event updated successfully");
            }
            else
            {
                System.out.println("Event update failed");
            }
        }
        catch (Exception e)
        {
            System.out.println("Error while trying to update event");
        }
    }
}
