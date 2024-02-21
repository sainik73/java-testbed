package com.java.examples.datastructure;

/**
 * This class represents a custom hashmap implementation.
 *
 * @author K Saini
 */
public class CustomHashMap {
    int capacity = 16;
    double loadFactor = 0.8;
    Object[] map;

    CustomHashMap() {
        map = new Object[capacity];
    }

    CustomHashMap(int initialCapacity) {
        capacity = initialCapacity;
        map = new Object[capacity];
    }

    /**
     * create a hashcode of key.
     * check if load factor is already reached.
     * if yes, resize the Object[]
     * check if hashcode is already present
     * if present, compare the object to be same by equals comparison.
     * if equal, throw exception, otherwise add to list
     * if not, create a linked list and store the object
     */
    public void put(Object key, Object val) {

    }

    /**
     * create a hashcode of key. Get the index of bucket
     * check if load factor is already reached.
     * if yes, resize the Object[]
     * check if hashcode is already present
     * if present, compare the object to be same by equals comparison.
     * if equal, get the value and replace it, otherwise add to list
     * if not, create a linked list and store the object
     */
    public void putIfAbsent(Object key, Object val) {

    }

    /**
     * create a hashcode of key. Get the index of bucket
     * retrieve the value otherwise return null.
     *
     * @param key
     * @return Object (value)
     */
    public Object get(Object key) {
        return null;
    }
}
