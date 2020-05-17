package tests;

import org.junit.jupiter.api.Test;
import routeCity.InitializeCity;
import routeCity.Node;
import routeCity.ShortestPath;

import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class IntegrationTests {

    /**
     * This test creates all nodes and sets connection, then checks if everything is connected.
     * This test might fail sometimes because we do not include the method that remakes the nodes if they are not connected.
     * This test gives us an idea of how often the program fail to connect on first try.
     */
    @Test
    void createAllNodes() {

        InitializeCity initializeCity = new InitializeCity();
        ArrayList<Node> testArray = new ArrayList<Node>();
        initializeCity.addNodesToArray(testArray);
        initializeCity.createAllRoads(testArray);

        assertTrue(initializeCity.checkIfConnected(0,testArray));
    }

    /**
     * Checks the shortest path using 3 different nodes.
     */
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
            assertEquals(recievedNodes[i].getName(), allNode[i].getName());
        }
    }
}