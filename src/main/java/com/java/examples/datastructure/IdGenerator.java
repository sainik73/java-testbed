package com.java.examples.datastructure;

import java.time.Instant;
import java.util.logging.Logger;

/**
 * This class is used to generate Id's on same lines as Twitter Snowflake Id Generator which can be used in
 * distributed applications for unique Id requirements.
 * The generated Id is in 64 bits.
 */
public class IdGenerator {
    // Lets mark the start time of IdGenerator
    private static final long CUSTOM_EPOCH =
            Instant.parse("2022-09-18T12:00:00.12Z").toEpochMilli();
    private static final int NODEIDBITS = 10;
    private static final int COUNTERBITS = 12;
    private static Logger logger = Logger.getLogger(IdGenerator.class.getName());
    private static boolean DEBUG_ON = true;

    private static long getTimestamp() {
        long id = Instant.now().toEpochMilli() - CUSTOM_EPOCH;
        if (DEBUG_ON) logger.info("getTimestamp binary: " + Long.toBinaryString(id));
        return id;
    }

    /**
     * Node id would be 10 bit (max 2 *(10) = 1024 values
     *
     * @return long representation of NodeId
     */
    private static long getNodeId() {
        long nodeId = (long) (Math.pow(2, 10) * Math.random());
        if (DEBUG_ON) logger.info("getNodeId: " + Long.toBinaryString(nodeId) + " : " + nodeId);
        return nodeId;
    }

    /**
     * Node id would be 10 bit (max 2 *(12) = 4096 values
     *
     * @return long representation of SequenceId
     */
    private static long getSequenceId() {
        long sequenceId = (long) (Math.pow(2, 12) * Math.random());
        if (DEBUG_ON) logger.info("getSequenceId: " + Long.toBinaryString(sequenceId) + " : " + sequenceId);
        return sequenceId;
    }

    public static void main(String[] args) {
        IdGenerator idGenerator = new IdGenerator();
        logger.info("Generated Id: " + idGenerator.generateId());
    }

    /**
     * Method to generate 64 bit Id
     *
     * @return binary string representation of Id
     */
    public String generateId() {
        long id = getTimestamp() << (NODEIDBITS + COUNTERBITS);
        if (DEBUG_ON) logger.info("After timebits: " + Long.toBinaryString(id));
        id |= (getNodeId() << COUNTERBITS);
        if (DEBUG_ON) logger.info("After NodeIdBits: " + Long.toBinaryString(id));
        id |= (getSequenceId());
        if (DEBUG_ON) {
            logger.info("After SequenceIdBits: " + Long.toBinaryString(id));
            logger.info("long Id: " + id);
        }

        return formatTo64Bits(id);
    }

    /**
     * Pad input to 64 bits and replace unused bits with Zeros
     *
     * @param input long representation of Id
     * @return output string object representing the 64 bit Id
     */
    private String formatTo64Bits(long input) {
        var OUTPUT_FORMAT = "%64s";
        return String.format(OUTPUT_FORMAT, Long.toBinaryString(input))
                .replace(' ', '0');
    }

}
