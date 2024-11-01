package org.example.events;

import org.example.util.SqlConnection;

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
            String sql = "select * from tblevents where fldDogID = ?";
            con = SqlConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, dogID);
            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {
                Event event = new Event();
                event.setEventID(rs.getInt(1));
                event.setEventDescription(rs.getString(2));
                event.setEventDate(rs.getDate(3));
                event.setEventTagID(rs.getInt(4));
                event.setDogID(rs.getInt(5));
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
            String sql = "select * from tblevents where fldEventID = ?";
            con = SqlConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, eventID);
            ResultSet rs = ps.executeQuery();
            if (rs.next())
            {
                Event event = new Event();
                event.setEventID(rs.getInt(1));
                event.setEventDescription(rs.getString(2));
                event.setEventDate(rs.getDate(3));
                event.setEventTagID(rs.getInt(4));
                event.setDogID(rs.getInt(5));
                return event;
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
            java.sql.Date sqlDate = new java.sql.Date(event.getEventDate().getTime());
            ps.setDate(2, sqlDate);
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
            String sql = "UPDATE tblEvents SET fldEventDescription = ?, fldEventDate = ?, fldDogID = ?, fldEventTagID WHERE fldEventID = ?";
            con = SqlConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, event.getEventDescription());
            java.sql.Date sqlDate = new java.sql.Date(event.getEventDate().getTime());
            ps.setDate(2, sqlDate);
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
