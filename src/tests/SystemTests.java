package tests;

import org.junit.jupiter.api.Test;
import routeCity.InitializeCity;
import routeCity.Node;

import java.util.ArrayList;

class SystemTests {

    @Test
    void systemTest() {
        //Create nodes
        InitializeCity initializeCity = new InitializeCity();
        ArrayList<Node> testArray = new ArrayList<Node>();
        initializeCity.addNodesToArray(testArray);
        initializeCity.createAllRoads(testArray);

        //Check shortestPath
    }
}