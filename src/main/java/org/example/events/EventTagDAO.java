package org.example.events;

import java.util.List;

public interface EventTagDAO
{
    List<EventTag> getAllEventTags();
    void createEventTag(EventTag tag);
    void updateEventTag(EventTag tag);
    void deleteEventTag(EventTag tag);
}
