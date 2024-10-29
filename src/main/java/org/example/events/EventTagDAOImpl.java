package org.example.events;

import java.util.List;

public class EventTagDAOImpl implements EventTagDAO
{

    @Override
    public List<EventTag> getAllEventTags() {
        String sql = "select * from tblEventTag";
        //Connection con = getConnection();
        return null;
    }

    @Override
    public void createEventTag(EventTag tag) {

    }

    @Override
    public void updateEventTag(EventTag tag) {

    }

    @Override
    public void deleteEventTag(EventTag tag) {

    }
}
