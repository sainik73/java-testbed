package com.java.examples.datastructure;

import java.util.Arrays;
import java.util.List;

/**
 * This DFS algorithm is implemented using recursion
 * @author Kiran
 * @since 3/26/2021
 */
public class DepthFirstSearch {
    private static int count = 0;
    public static void main(String[] args) {
        List<Vertex> vertices = bootStrapData();
        System.out.println("Graph data bootstrapped....");
        traverseGraph(vertices);
        System.out.println("Total loop count: "+ count);
    }

    /**
     * This method uses recursion to traverse the graph
     * @param vertexList graph to traverse
     * @return int count of loop to traverse the graph
     */
    public static int traverseGraph(List<Vertex> vertexList) {
        for (Vertex v: vertexList){
            count++;
            if(!v.isVisited()){
                System.out.println("Going to Visit: "+ v);
                v.setVisited(true);
                traverseGraph(v.getChildVertex());
            }else{
                System.out.println("Already Visited: "+ v);
            }
        }
        return count;
    }



    /**
     * Graph to be bootstrapped
     *
     *          v8------v6--------------|
     *          |       |               |
     *  v1------v2-----v4-------v7------v9------v10
     *  |                       |
     *  |_______v3_____________v5
     */
    private static List<Vertex> bootStrapData() {
        Vertex v1 = new Vertex("V1");
        Vertex v2 = new Vertex("V2");
        Vertex v3 = new Vertex("V3");
        Vertex v4 = new Vertex("V4");
        Vertex v5 = new Vertex("V5");
        Vertex v6 = new Vertex("V6");
        Vertex v7 = new Vertex("V7");
        Vertex v8 = new Vertex("V8");
        Vertex v9 = new Vertex("V9");
        Vertex v10 = new Vertex("V10");

        //Add child
        v1.addChildVertex(v2);
        v2.addChildVertex(v4);
        v1.addChildVertex(v3);
        v2.addChildVertex(v1);
        v2.addChildVertex(v8);
        v3.addChildVertex(v5);
        v3.addChildVertex(v1);
        v4.addChildVertex(v6);
        v4.addChildVertex(v7);
        v4.addChildVertex(v2);
        v5.addChildVertex(v7);
        v5.addChildVertex(v3);
        v6.addChildVertex(v4);
        v6.addChildVertex(v8);
        v6.addChildVertex(v9);
        v7.addChildVertex(v4);
        v7.addChildVertex(v5);
        v7.addChildVertex(v9);
        v8.addChildVertex(v6);
        v8.addChildVertex(v2);
        v9.addChildVertex(v7);
        v9.addChildVertex(v10);
        v10.addChildVertex(v9);

        return Arrays.asList(v1,v2,v3,v4,v5,v6,v7,v8,v9,v10);

    }
}
