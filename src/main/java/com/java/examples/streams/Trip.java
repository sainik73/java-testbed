package com.java.examples.streams;

import java.sql.Timestamp;

/**
 * This class represents a trip from source to destination and time details
 */
public class Trip {
    private String source;
    private String destination;
    private Timestamp startTime;
    private Timestamp endTime;

    public Trip(String source, String destination, Timestamp startTime, Timestamp endTime) {
        this.source = source;
        this.destination = destination;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Trip() {
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }
}
