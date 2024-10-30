package org.example.events;

import java.util.Date;

public class Event
{
    private int eventID;
    private String eventDescription;
    private Date eventDate;
    private int eventTagID;
    private int dogID;

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public void setEventTagID(int eventTagID) {
        this.eventTagID = eventTagID;
    }

    public void setDogID(int dogID) {
        this.dogID = dogID;
    }

    public int getDogID() {
        return dogID;
    }

    public int getEventTagID() {
        return eventTagID;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public int getEventID() {
        return eventID;
    }


    public Event(int eventID, String eventDescription, Date eventDate, int eventTagID, int dogID)
    {
        this.eventID = eventID;
        this.eventDescription = eventDescription;
        this.eventDate = eventDate;
        this.eventTagID = eventTagID;
        this.dogID = dogID;
    }


}
