package com.java.examples.datastructure;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.logging.Level;
import java.util.logging.Logger;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCustomJavaList {
    private static Logger logger = Logger.getLogger(TestCustomJavaList.class.getName());

    CustomJavaList cjl;

    @BeforeAll
    static void setup() {
        logger.log(Level.INFO, () -> "@BeforeAll executed");
    }

    @BeforeEach
    void setupThis() {
        cjl = new CustomJavaList();
        logger.log(Level.INFO, () -> "@BeforeEach executed");
    }

    @Test
    public void givenAList_WhenAddingElementsToList_ThenItContainsThoseElements() throws Exception {
        logger.log(Level.INFO, () -> "givenAList_WhenAddingElementsToList_ThenItContainsThoseElements");
        cjl.add(3);
        cjl.add(5);
        cjl.add(13);
        cjl.add(24);
        cjl.printList();

        assertNotNull(cjl.get(2));
    }

    @Test
    public void givenAList_WhenAddingElementsToListBeyondInitialCapacity_ThenItEnsuresCapacity() throws Exception {
        logger.log(Level.INFO, () -> "givenAList_WhenAddingElementsToListBeyondInitialCapacity_ThenItEnsuresCapacity");
        cjl.add(3);
        cjl.add(5);
        cjl.add(13);
        cjl.add(24);
        cjl.add(7);
        cjl.add(16);
        cjl.add(25);
        cjl.add(43);
        cjl.add(14);
        cjl.add(70);
        cjl.add(33);
        cjl.add(65);
        cjl.add(103);
        cjl.add(124);
        cjl.add(237);
        cjl.printList();
        assertEquals(cjl.getCapacity(),20);
    }

    @Test
    public void givenAList_WhenRemovingElementsFromList_ThenItRemovesThoseElements() throws Exception {
        logger.log(Level.INFO, () -> "givenAList_WhenAddingElementsToList_ThenItContainsThoseElements");
        cjl.add(3);
        cjl.add(5);
        cjl.add(13);
        cjl.add(24);

        cjl.printList();
        cjl.remove(2);

        assertEquals(3, cjl.getSize());
    }

    @Test
    public void givenAList_WhenRemovingElementsFromListMoreThanIndex_ThenItThrowsException() throws Exception {
        logger.log(Level.INFO, () -> "givenAList_WhenAddingElementsToList_ThenItContainsThoseElements");
        cjl.add(3);
        cjl.add(5);
        cjl.add(13);
        cjl.add(24);

        cjl.printList();
        cjl.remove(5);

        assertEquals(4, cjl.getSize());
    }
}
