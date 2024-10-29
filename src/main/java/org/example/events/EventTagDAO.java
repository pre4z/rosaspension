package org.example.events;

import java.util.List;

public interface EventTagDAO
{
    List<EventTag> getAllEventTags() throws Exception;
    void createEventTag(String tagName) throws Exception;
    void updateEventTag(EventTag tag) throws Exception;
    void deleteEventTag(int eventTagID) throws Exception;
}
