package routeCity;

import java.util.HashMap;
import java.util.Map;

public class Node {

    public String name;
    public boolean minRoads = false;
    public boolean maxRoads = false;
    Map<Node, Integer> adjacentNodes = new HashMap<>();

    public Node(String name) {
        this.name = name;
    }

    public void addDestination(Node node,int distance) {
        adjacentNodes.put(node,distance);
    }
}
