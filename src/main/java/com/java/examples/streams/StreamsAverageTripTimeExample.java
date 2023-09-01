package com.java.examples.streams;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

public class StreamsAverageTripTimeExample {
    private static final String SAN_DIEGO = "San Diego";
    private static final String LAS_VEGAS = "Las Vegas";
    private static final String NEW_YORK = "New York";
    private static final String LOS_ANGELES = "Los Angeles";

    public static void main(String[] args) {
        List<Trip> allTrips = getAllTrips();
//find average between LOS ANGELES and LAS VEGAS
        OptionalDouble tripAverage = allTrips.stream()
                .filter(trip -> trip.getSource().equals(LOS_ANGELES) && trip.getDestination().equals(LAS_VEGAS))
                .map(trip -> Math.abs(trip.getEndTime().getTime() - trip.getStartTime().getTime()))
                .mapToLong(Long::longValue).average();
        if (tripAverage.isPresent()) {
            System.out.println("Trip average between " + LOS_ANGELES + " & " + LAS_VEGAS + " is: " +
                    String.format("%.2f", tripAverage.getAsDouble() / (1000 * 60 * 60)) + " hours");
        }
    }


    private static List<Trip> getAllTrips() {
        LocalDateTime local = LocalDateTime.now();
        Trip t1 = Trip.builder()
                .source(SAN_DIEGO).destination(LAS_VEGAS)
                .startTime(Timestamp.valueOf(local.minusDays(10)))
                .endTime(Timestamp.valueOf(local.minusDays(5)))
                .build();

        Trip t2 = new Trip(LOS_ANGELES, LAS_VEGAS,
                Timestamp.valueOf(local.minusDays(2)), Timestamp.valueOf(local.minusDays(1)));
        Trip t3 = new Trip(SAN_DIEGO, NEW_YORK,
                Timestamp.valueOf(local.minusHours(166)), Timestamp.valueOf(local.minusDays(1)));
        Trip t4 = new Trip(LOS_ANGELES, LAS_VEGAS,
                Timestamp.valueOf(local.minusHours(100)), Timestamp.valueOf(local.minusDays(2)));
        Trip t5 = new Trip(LOS_ANGELES, NEW_YORK,
                Timestamp.valueOf(local.minusHours(100)), Timestamp.valueOf(local.minusDays(2)));
        Trip t6 = new Trip(SAN_DIEGO, LAS_VEGAS,
                Timestamp.valueOf(local.minusDays(8)), Timestamp.valueOf(local.minusDays(5)));
        Trip t7 = new Trip(SAN_DIEGO, LAS_VEGAS,
                Timestamp.valueOf(local.minusHours(120)), Timestamp.valueOf(local.minusHours(5)));
        Trip t8 = new Trip(SAN_DIEGO, NEW_YORK,
                Timestamp.valueOf(local.minusHours(86)), Timestamp.valueOf(local.minusDays(1)));
        Trip t9 = new Trip(LOS_ANGELES, LAS_VEGAS,
                Timestamp.valueOf(local.minusHours(160)), Timestamp.valueOf(local.minusDays(2)));
        Trip t10 = new Trip(LOS_ANGELES, LAS_VEGAS,
                Timestamp.valueOf(local.minusHours(200)), Timestamp.valueOf(local.minusDays(2)));

        return Arrays.asList(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10);

    }

}
