package tests;

import org.junit.jupiter.api.Test;
import routeCity.InitializeCity;
import routeCity.Node;
import routeCity.ShortestPath;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

class SystemTests {

    @Test
    void systemTest() {
        //Create nodes
        InitializeCity initializeCity = new InitializeCity();
        ShortestPath shortestPath = new ShortestPath();
        ArrayList<Node> testArray = new ArrayList<Node>();
        ArrayList<Node> possibleRoutes = new ArrayList();
        ArrayList<Node[]> foundRoutes = new ArrayList<>();
        Node[] finalRoute;

        initializeCity.addNodesToArray(testArray);
        initializeCity.createAllRoads(testArray);

        foundRoutes = shortestPath.GPS(testArray.get(0),testArray,foundRoutes,possibleRoutes,testArray.get(9));
        finalRoute = shortestPath.shortestPath(foundRoutes,testArray.get(9));

        int foundRoutesDistance = 101;
        int tempInt = 0;

        //räknar ut den kortatse
        if (testArray.get(0).adjacentNodes.containsKey(testArray.get(9))){
            foundRoutesDistance = testArray.get(0).adjacentNodes.get(testArray.get(9));
        }else {
            for (Node[] foundRoute : foundRoutes) {
                System.out.println("_______________");
                for (int j = 0; j < foundRoute.length - 1; j++) {
                    System.out.println(foundRoute[j].getName());
                    tempInt += foundRoute[j].adjacentNodes.get(foundRoute[j + 1]);
                    if (foundRoute[j + 1].adjacentNodes.containsKey(testArray.get(9))) {
                        if (tempInt < foundRoutesDistance) {
                            foundRoutesDistance = tempInt;
                        }
                        tempInt = 0;
                    }
                }
            }
        }
        System.out.println("------------------------");
        //Kollar hur lång den som man får tillbaka av metoden
        int finalRouteDistance = 0;
        if (testArray.get(0).adjacentNodes.containsKey(testArray.get(9))){
            finalRouteDistance = testArray.get(0).adjacentNodes.get(testArray.get(9));
        }else {
            for (int i = 0; i < finalRoute.length-1; i++) {
                System.out.println(finalRoute[i].getName());
                    finalRouteDistance += finalRoute[i].adjacentNodes.get(finalRoute[i + 1]);
            }
        }

        //stämmer överens
        System.out.println("size: " + finalRoute.length);
        System.out.println(finalRoute[0].adjacentNodes.get(finalRoute[1]) + " " + finalRoute[finalRoute.length-1].adjacentNodes.get(finalRoute[finalRoute.length-2]));
        System.out.println(finalRouteDistance+"  "+foundRoutesDistance);
        assertEquals(finalRouteDistance,foundRoutesDistance,"Not same length/shortest path");

        //Check shortestPath
    }
}