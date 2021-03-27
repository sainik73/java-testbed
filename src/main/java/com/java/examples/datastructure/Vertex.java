package com.java.examples.datastructure;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kiran
 * @since 3/26/2021
 */
public class Vertex {
    private String name;
    private boolean isVisited;
    private List<Vertex> childVertexList;

    public Vertex(String name) {
        this.name = name;
        childVertexList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }

    public List<Vertex> getChildVertex() {
        return childVertexList;
    }

    public void addChildVertex(Vertex newChild) {
        this.childVertexList.add(newChild);
    }

    @Override
    public String toString() {
        return "Vertex{" +
                       "name='" + name + '\'' +
                       '}';
    }
}
