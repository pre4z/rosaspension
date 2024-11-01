package org.example.events;

import org.example.util.SqlConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EventTagDAOImpl implements EventTagDAO
{

    @Override
    public List<EventTag> getAllEventTags() throws Exception
    {
        Connection con = null;
        List<EventTag> eventTags = new ArrayList<EventTag>();
        try
        {
            String sql = "SELECT * FROM tblEventTag";
            con = SqlConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next())
            {
                EventTag eventTag = new EventTag();
                eventTag.setEventTagID(rs.getInt(1));
                eventTag.setTagName(rs.getString(2));
                eventTags.add(eventTag);
            }
            return eventTags;
        }
        catch(Exception e)
        {
            System.out.println("Error while trying to get event tags");
        }
        return eventTags;
    }

    @Override
    public void createEventTag(String tagName) throws Exception
    {
        Connection con = null;
        try
        {
            String sql = "insert into tblEventTag (fldTagName) values (?)";
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
            System.out.println("Error while trying to create event tag");
        }
    }

    @Override
    public void updateEventTag(EventTag tag) throws Exception
    {
        Connection con = null;
        try
        {
            String sql = "update tblEventTag set fldTagName = ? where fldEventTagID = ?";
            con = SqlConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, tag.getTagName());
            ps.setInt(2, tag.getEventTagID());
            int affectedRows = ps.executeUpdate();
            if (affectedRows > 0)
            {
                System.out.println("EventTag updated successfully");
            }
            else
            {
                System.out.println("EventTag updated failed");
            }
        }
        catch(Exception e)
        {
            System.out.println("Error while trying to update event tag");
        }
    }

    @Override
    public void deleteEventTag(int eventTagID) throws Exception
    {
        Connection con = null;
        try
        {
            String sql = "delete from tblEventTag where fldEventTagID = ?";
            con = SqlConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, eventTagID);
            int affectedRows = ps.executeUpdate();
            if (affectedRows > 0)
            {
                System.out.println("EventTag deleted successfully");
            }
            else
            {
                System.out.println("EventTag deleted failed");
            }
        }
        catch(Exception e)
        {
            System.out.println("Error while trying to delete event tag");
        }
    }
}
