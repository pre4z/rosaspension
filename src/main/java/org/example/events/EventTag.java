package org.example.events;

public class EventTag {
    private int eventTagID;
    private String tagName;

    public void setEventTagID(int eventTagID) {
        this.eventTagID = eventTagID;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

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
    public EventTag(){}
}
