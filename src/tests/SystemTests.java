package tests;

import org.junit.jupiter.api.Test;
import routeCity.InitializeCity;
import routeCity.Node;
import routeCity.ShortestPath;

import java.util.ArrayList;

class SystemTests {

    @Test
    void systemTest() {
        //Create nodes
        InitializeCity initializeCity = new InitializeCity();
        ShortestPath shortestPath = new ShortestPath();
        ArrayList<Node> testArray = new ArrayList<Node>();

        initializeCity.addNodesToArray(testArray);
        initializeCity.createAllRoads(testArray);

        shortestPath.getShortestPath(testArray,testArray.get(0),testArray.get(9));



        //Check shortestPath
    }
}