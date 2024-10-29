package org.example.events;

public class EventTag {
    private int eventTagID;
    private String tagName;

    public int getEventTagID() {
        return eventTagID;
    }

    public String getTagName() {
        return tagName;
    }

    public EventTag(int eventTagID, String tagName)
    {
        this.eventTagID = eventTagID;
        this.tagName = tagName;
    }
}
