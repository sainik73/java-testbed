package com.java.examples.datastructure;

import java.util.Arrays;
import java.util.logging.Logger;

import static java.util.Arrays.copyOf;

/**
 * This class is an implementation of java list using Arrays.
 */
public class CustomJavaList<E> {
    private static Logger logger = Logger.getLogger(CustomJavaList.class.getName());

    private int size = 0;
    // initial capacity
    private int capacity = 10;

    private Object[] elements = null;

    CustomJavaList(){
        elements = new Object[capacity];
    }

    /**
     * Method to add a new element to list
     * @param e
     */
    public void add(E e){
        //check if the list size is fill to capacity, then increase the capacity
        if(size == capacity){
            //increase the capacity
            increaseCapacity();
        }
        elements[size++] = e;
    }

    /**
     * Method to get an item from the list
     * @param i
     * @return
     */
    public E get(int i){
        if(i<0 || i>=size){
            throw new ArrayIndexOutOfBoundsException("Index is not valid, index= " + i + " ,Size=" + size);
        }
        return (E) elements[i];
    }

    /**
     * Method to remove an item from the list
     * @param index
     * @return
     */
    public void remove(int index){
        if(index<0 || index>=size){
            throw new ArrayIndexOutOfBoundsException("Index is not valid, index= " + index + " ,Size=" + size);
        }
        //get a sub array upto the index
        Object[] temp1 = (Object[]) Arrays.copyOfRange(elements,0,index);
        // increase the capacity to hold additional elements upto capacity of orig array
        Object[] tempNew = Arrays.copyOf(temp1,capacity);
        temp1 = null;
        //get a sub array from index to size of orig array (elements)
        Object[] temp2 = (Object[]) Arrays.copyOfRange(elements,++index,size--);
        //copy
        System.arraycopy(temp2,0,tempNew,--index,temp2.length);

    }

    /**
     * Method to double the capacity
     */
    private void increaseCapacity(){
        elements = Arrays.copyOf(elements,capacity = capacity*2);
    }

    public void printList() {
        StringBuilder sb = new StringBuilder("[");
        for (int i=0; i<size; i++) {
            sb.append(elements[i]);
            sb.append(",");
        }
        sb.delete(sb.length()-1,sb.length());
        sb.append("]");
        System.out.println(sb.toString());
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
