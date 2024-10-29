package org.example.events;

import java.util.List;

public interface EventsDAO
{
    List<Event> getAllEventsByDogID(int dogID) throws Exception;
    Event getEventById(int eventID) throws Exception;
    void CreateEvent(Event event) throws Exception;
    void UpdateEvent(Event event) throws Exception;
}
