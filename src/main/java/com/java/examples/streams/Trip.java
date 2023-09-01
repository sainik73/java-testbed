package com.java.examples.streams;

import lombok.Builder;
import lombok.Value;

import java.sql.Timestamp;

/**
 * This class represents a trip from source to destination and time details
 */
@Builder
@Value
public class Trip {
    private String source;
    private String destination;
    private Timestamp startTime;
    private Timestamp endTime;


}
