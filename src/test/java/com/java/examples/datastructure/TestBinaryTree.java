package com.java.examples.datastructure;

import org.junit.jupiter.api.*;

import java.util.logging.Level;
import java.util.logging.Logger;

import static com.java.examples.datastructure.Node.nodeExists;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class TestBinaryTree {
    private static Logger logger = Logger.getLogger(TestBinaryTree.class.getName());

    BinaryTree bt;
    @BeforeAll
    static void setup(){
        logger.log(Level.INFO, ()-> "@BeforeAll executed");
    }

    @BeforeEach
    void setupThis(){
        bt = new BinaryTree();
        logger.log(Level.INFO, ()-> "@BeforeEach executed");
    }

    @Test
    public void givenABinaryTree_WhenAddingNodes_ThenTreeContainsThoseNodes() throws Exception {
        logger.log(Level.INFO, ()-> "givenABinaryTree_WhenAddingNodes_ThenTreeContainsThoseNodes");
        bt.addNode(10);
        bt.addNode(6);
        bt.addNode(15);
        bt.addNode(4);

        assertTrue(bt.findNode(6).getValue() == 6);
        assertTrue(bt.findNode(4).getValue() == 4);

        assertFalse(nodeExists(bt.findNode(1)));
    }

    @Test
    public void givenABinaryTree_WhenNodeIsNotAdded_ThenTreeDoesnotContainsThoseNodes() throws Exception {
        logger.log(Level.INFO, ()-> "givenABinaryTree_WhenNodeIsNotAdded_ThenTreeDoesnotContainsThoseNodes");
        bt.addNode(10);
        bt.addNode(6);
        bt.addNode(15);
        bt.addNode(4);

        assertFalse(nodeExists(bt.findNode(1)));
    }

    @Test
    public void givenABinaryTree_WhenStarterNodeIsRequestedToDelete_ThenTreeDoesnotDeleteThatNode() throws Exception {
        logger.log(Level.INFO, ()-> "givenABinaryTree_WhenStarterNodeIsRequestedToDelete_ThenTreeDoesnotDeleteThatNode");
        bt.setStarterNode(new Node(10));
        bt.addNode(6);
        bt.addNode(15);
        bt.addNode(4);

        assertFalse(bt.deleteNode(10));
    }

    @Test
    public void givenABinaryTree_WhenLastChildNodeIsRequestedToDelete_ThenTreeDeletesThatNode() throws Exception {
        logger.log(Level.INFO, ()-> "givenABinaryTree_WhenLastChildNodeIsRequestedToDelete_ThenTreeDeletesThatNode");
        bt.setStarterNode(new Node(10));
        bt.addNode(6);
        bt.addNode(15);
        bt.addNode(4);

        assertTrue(bt.deleteNode(4));
    }

    @Test
    public void givenABinaryTree_WhenNodeWithOneChildIsRequestedToDelete_ThenTreeDeletesThatNode() throws Exception {
        logger.log(Level.INFO, ()-> "givenABinaryTree_WhenLastChildNodeIsRequestedToDelete_ThenTreeDeletesThatNode");
        bt.setStarterNode(new Node(10));
        bt.addNode(6);
        bt.addNode(15);
        bt.addNode(4);
        bt.addNode(18);

        assertTrue(bt.deleteNode(6));
        assertTrue(bt.deleteNode(15));
    }

    @AfterEach
    void tearThis(){
        bt = null;
        logger.log(Level.INFO, ()-> "@AfterEach executed");
    }

    @AfterAll
    static void tear(){
        logger.log(Level.INFO, ()-> "@AfterAll executed");
    }

}
