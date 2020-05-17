package tests;

import routeCity.InitializeCity;
import routeCity.Node;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class InitializeCityTest {

    @org.junit.jupiter.api.Test
    void createAllRoads() {
        InitializeCity initializeCity = new InitializeCity();
        ArrayList<Node> allNodes = new ArrayList<>();
        allNodes.addAll(initializeCity.addNodesToArray(allNodes));
        initializeCity.createAllRoads(allNodes);

        for (Node allNode : allNodes) {
            assertTrue(allNode.isMinRoads(), "Not enough roads");
        }
    }

   /* @org.junit.jupiter.api.Test
    void replaceRoad() {
        InitializeCity initializeCity = new InitializeCity();
        Node node1 = new Node("1");
        Node node2 = new Node("2");
        Node node3 = new Node("3");

        node1.adjacentNodes.put(node2,5);
        node1.adjacentNodes.put(node2,5);
        node1.adjacentNodes.put(node2,5);

        ArrayList<Node> nodes = new ArrayList<>();
        nodes.add(node1);
        nodes.add(node2);
        nodes.add(node3);

        initializeCity.replaceRoad(nodes);

        assertEquals(2,node1.adjacentNodes.size());
        assertEquals(2,node2.adjacentNodes.size());
        assertEquals(1,node3.adjacentNodes.size());
    }*/

    @org.junit.jupiter.api.Test
    void checkIfConnected() {
        InitializeCity initializeCity = new InitializeCity();
        ArrayList<Node> allNodes = new ArrayList<>();
        allNodes.addAll(initializeCity.addNodesToArray(allNodes));
        initializeCity.createAllRoads(allNodes);

        assertTrue(initializeCity.checkIfConnected(0,allNodes),"Not connected");
    }

    @org.junit.jupiter.api.Test
    void addRoad() {

        InitializeCity initializeCity = new InitializeCity();

        Node node1 = new Node("1");
        Node node2 = new Node("2");
        Node node3 = new Node("3");
        Node node4 = new Node("4");

        node3.setMaxRoads(true);
        initializeCity.addRoad(node1,node4);

        assertFalse(initializeCity.addRoad(node1,node4));
        assertFalse(initializeCity.addRoad(node1,node3));
        assertFalse(initializeCity.addRoad(node1,node1));
        assertTrue(initializeCity.addRoad(node1,node2));
    }

    @org.junit.jupiter.api.Test
    void countRoadsSetStatus() {
        InitializeCity initializeCity = new InitializeCity();
        Node testNode = new Node("test");

        testNode.adjacentNodes.put(testNode,3);
        initializeCity.countRoadsSetStatus(testNode);
        assertFalse(testNode.isMinRoads());
    }

    @org.junit.jupiter.api.Test
    void addNodesToArray() {
        InitializeCity initializeCity = new InitializeCity();

        ArrayList<Node> nodes = new ArrayList<>();
        initializeCity.addNodesToArray(nodes);

        assertEquals(10,nodes.size());
    }
}