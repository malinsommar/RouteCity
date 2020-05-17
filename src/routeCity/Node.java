package routeCity;

import java.util.HashMap;
import java.util.Map;

public class Node {

    String name;
    boolean minRoads = false;
    boolean maxRoads = false;
    public Map<Node, Integer> adjacentNodes = new HashMap<>();

    public String getName() {
        return name;
    }

    public boolean isMinRoads() {
        return minRoads;
    }

    void setMinRoads(boolean minRoads) {
        this.minRoads = minRoads;
    }

    boolean isMaxRoads() {
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
