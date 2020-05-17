package tests;

import org.junit.jupiter.api.Test;
import routeCity.InitializeCity;
import routeCity.Node;

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
}