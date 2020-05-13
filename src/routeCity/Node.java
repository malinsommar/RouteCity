package routeCity;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Node {

    public String name;
    private List<Node> shortestPath = new LinkedList<>();
    private Integer distance = Integer.MAX_VALUE;
    public boolean minRoads = false;
    public boolean maxRoads = false;
    Map<Node, Integer> adjacentNodes = new HashMap<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isMinRoads() {
        return minRoads;
    }

    public void setMinRoads(boolean minRoads) {
        this.minRoads = minRoads;
    }

    public boolean isMaxRoads() {
        return maxRoads;
    }

    public void setMaxRoads(boolean maxRoads) {
        this.maxRoads = maxRoads;
    }

    public Node(String name) {
        this.name = name;
    }

    public void addDestination(Node node,int distance) {
        adjacentNodes.put(node,distance);
    }
}
