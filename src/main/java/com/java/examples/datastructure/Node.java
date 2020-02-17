package com.java.examples.datastructure;

import java.util.logging.Logger;

/**
 * This class represents a Node in a binary tree.
 * @version 1.0 Initial version
 *
 */
public class Node {
    private static Logger logger = Logger.getLogger(Node.class.getName());
    private int value;
    private Node left = null;
    private Node right = null;

    public Node(int value){
        this.value = value;
    }

    /**
     * This method will add a new node by traversing
     * through the binary tree and finding the correct place to
     * insert a new node.
     * @param newNodeValue
     */
    public  void addNode(int newNodeValue){
        if(newNodeValue <= value) {
            //go left and see if left node exists
            if (nodeExists(left)) {
                //traverse the tree
                left.addNode(newNodeValue);
            } else {
                //create new left node
                left = new Node(newNodeValue);
            }
        }else {
            //go right and see if right node exists
            if (nodeExists(right)) {
                //traverse the tree
                right.addNode(newNodeValue);
            } else {
                //create new right node
                right = new Node(newNodeValue);
            }
        }
    }

    /**
     * This method will find and return the node in a binary tree
     * @param valueToFind
     * @return Node
     */
    public Node findNode(int valueToFind) throws Exception {
        Node finderNode = null;
        //find the traversal side - left or right
        if(valueToFind == value){
            finderNode= this;
        //traverse left
        }else if(nodeExists(left)){
            if(left.value == valueToFind) {
                finderNode = left;
            }else {
                finderNode = left.findNode(valueToFind);
            }
        //traverse right
        }else if(nodeExists(right)){
            if (right.value == valueToFind) {
                finderNode = right;
            } else {
                finderNode = right.findNode(valueToFind);
            }
        }
        //else throw new Exception("Node not found in the binary tree search!!");

        return finderNode;
    }

    /**
     * Method to check if the node exists then return true
     * otherwise return false
     * @param node
     * @return boolean
     */
    public static boolean nodeExists(Node node){
        boolean exist = true;
        if(null == node){
            exist = false;
        }
        return exist;
    }

    public static void printBinaryTree(Node node, String side, int level){
        if(nodeExists(node)){
            System.out.println("Level "+ side + level++ +" : value= " + node.value);
            if(nodeExists(node.left)) {
                printBinaryTree(node.left, "left", level);
            }
            if(nodeExists(node.right)){
                printBinaryTree(node.right, "right", level);
            }
        }else{
            System.out.println("Node does not exist in binary tree.");
        }

    }

    @Override
    public String toString() {
        return super.toString();
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
