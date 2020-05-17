package tests;

import org.junit.jupiter.api.Test;
import routeCity.Node;
import routeCity.ShortestPath;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ShortestPathTest {

    @Test
    void getShortestPath() {
            ShortestPath shortestPath = new ShortestPath();
            ArrayList<Node> allNodes = new ArrayList<>();
            Node[] allNode = new Node[3];

        for (int i = 0; i < 3; i++) {
            allNodes.add(new Node(Character.toString((char)(65+i))));
            if (i>0)allNodes.get(i-1).addDestination(allNodes.get(i),i);

            allNode[i] = new Node(Character.toString((char)(65+i)));
            if (i>0)allNode[i-1].addDestination(allNode[i],i);
        }

        Node []recievedNodes = shortestPath.getShortestPath(allNodes, allNodes.get(0), allNodes.get(2));

        for (int i = 0; i < recievedNodes.length; i++) {
            assertEquals(recievedNodes[i].name, allNode[i].name);
        }
    }
}