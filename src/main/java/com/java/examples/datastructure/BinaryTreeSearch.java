package com.java.examples.datastructure;

import java.util.Arrays;
import java.util.Collections;
import java.util.logging.Logger;

import static com.java.examples.datastructure.Node.nodeExists;
import static com.java.examples.datastructure.Node.printBinaryTree;

public class BinaryTreeSearch {
    private static Logger logger = Logger.getLogger(BinaryTreeSearch.class.getName());

    public static void main(String[] args)throws Exception {
        // create binary tree with new nodes
        int sizeOfArray=100000;
        int[] nodesRawArray = new int[sizeOfArray];//{34,9,2,65,23,87,54,33,56,55,76,3,35,65,83,26,11,46,38,99,22,41,40,99,88,44,55,83,45,60,73,35,67,89};
        for (int iCounter=0; iCounter< nodesRawArray.length;iCounter++ ) {
            nodesRawArray[iCounter]= (int)(Math.random()*sizeOfArray);
            //System.out.println("iCounter["+ iCounter + "]: " +nodesRawArray[iCounter]);
        }
        // distinct array
        int[] nodesArray = Arrays.stream(nodesRawArray).distinct().toArray();

        //create binary tree with starter node at half of array size.
        Node starterNode = new Node(sizeOfArray/2);
        for (int value:nodesArray ) {
            starterNode.addNode(value);
        }
        //Print the binary array with the levels
        printBinaryTree(starterNode,"root",0);

        //set the node value randomly
        int valueToSetAndFind = (int)(Math.random()*sizeOfArray);
        starterNode.addNode(valueToSetAndFind);

        //find a node in tree
        long startTime = System.nanoTime();
        Node foundNode = starterNode.findNode(valueToSetAndFind);
        long stopTime = System.nanoTime();
        logger.info("Time taken to find Node with Value " + valueToSetAndFind + " :: "+ (stopTime-startTime) +" nanoseconds. ");

        //find non existent node
        int valueToFind = 52;
        Node nnode = starterNode.findNode(valueToFind);
        System.out.println("Found Node with value " + valueToFind + " :: "+ nodeExists(nnode));


    }
}
