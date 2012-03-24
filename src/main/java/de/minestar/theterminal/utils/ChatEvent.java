package de.minestar.theterminal.utils;

public class ChatEvent {

    private final long timestamp;
    private final String playerName, displayName, message;
    private final EventType eventType;

    public ChatEvent(String playerName, String displayName, String message, EventType eventType) {
        this.timestamp = System.currentTimeMillis();
        this.playerName = playerName;
        this.displayName = displayName;
        this.message = message;
        this.eventType = eventType;
    }

    /**
     * @return the displayName
     */
    public String getDisplayName() {
        return displayName;
    }
    /**
     * @return the timestamp
     */
    public long getTimestamp() {
        return timestamp;
    }

    /**
     * @return the playerName
     */
    public String getPlayerName() {
        return playerName;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    public boolean isYounger(long time) {
        return this.timestamp >= time;
    }

    public boolean isOlder(long time) {
        return this.timestamp <= time;
    }

    /**
     * @return the eventType
     */
    public EventType getEventType() {
        return eventType;
    }
}
