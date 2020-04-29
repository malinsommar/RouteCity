package routeCity;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Node {

    private String name;
    private List<Node> shortestPath = new LinkedList<>();
    private Integer distance = Integer.MAX_VALUE;
    public boolean threeRoads = false;
    Map<Node, Integer> adjacentNodes = new HashMap<>();

   /* public void addDestination(Node destination, int distance) {
        adjacentNodes.put(destination, distance);
    }*/

    public Node(String name) {
        this.name = name;
    }

    public void addDestination(Node node) {
        adjacentNodes.put(node,(int)(Math.random()*10)+1);
    }

    // getters and setters
}
